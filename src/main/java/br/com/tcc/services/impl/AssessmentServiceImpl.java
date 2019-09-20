package br.com.tcc.services.impl;

import br.com.tcc.dao.AssessmentDAO;
import br.com.tcc.dao.metadata.enums.AssessmentStatus;
import br.com.tcc.dto.Process;
import br.com.tcc.dto.*;
import br.com.tcc.services.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentDAO assessmentDAO;

    @Autowired
    public AssessmentServiceImpl(AssessmentDAO assessmentDAO) {
        this.assessmentDAO = assessmentDAO;
    }

    @Override
    public Collection<Assessment> list() {
        return this.assessmentDAO.list();
    }

    @Override
    public Collection<Assessment> list(Integer idUser) {
        return this.assessmentDAO.list(idUser);
    }

    @Override
    public Assessment get(Integer idAssessment) {
        return this.assessmentDAO.get(idAssessment);
    }

    @Override
    public Integer register(Assessment assessment) {
        assessment
                .setDate(LocalDateTime.now())
                .setStatus(assessment.getStatus() == null ? AssessmentStatus.in_progress : assessment.getStatus());
        return this.assessmentDAO.register(assessment);
    }

    @Override
    public Integer update(Integer idAssessment, Assessment assessment) {
        assessment.setDate(LocalDateTime.now());
        return this.assessmentDAO.update(idAssessment, assessment);
    }

    @Override
    public Integer delete(Integer idAssessment) {
        return this.assessmentDAO.delete(idAssessment);
    }

    @Override
    public Assessment finish(Assessment assessment) {
        this.checkMaturity(assessment);
        if (assessment.getIdAssessment() != null) {
            this.update(assessment.getIdAssessment(), assessment);
        } else {
            this.register(assessment);
        }
        return assessment;
    }

    @SuppressWarnings("unchecked")
    private void checkMaturity(Assessment assessment) {
        JsonAssessment jsonAssessment = assessment.getJsonAssessment();
        List<LevelResult> levelResults = new ArrayList<>();
        Classification targetLevel = jsonAssessment.getTargetLevel();
        MeasurementFramework measurementFramework = jsonAssessment.getMeasurementFramework();
        ReferenceModel referenceModel = jsonAssessment.getReferenceModel();
        Collection<Classification> classifications = this.getClassifications(targetLevel, measurementFramework);
        Collection<CapacityLevel> capacityLevels = this.getCapacityLevels(classifications, measurementFramework.getCapacityLevels());

        classifications.forEach(classification -> {
            LevelResult levelResult = new LevelResult().setClassification(classification);
            Collection<Process> processes = ((Collection<Process>) this.getProcessByTargetLevel(classification.getLevels(), referenceModel));
            Collection<String> idsProcess = processes.stream().map(Process::getIdProcess).collect(Collectors.toList());
            levelResults.add(levelResult);
        });
        AtomicReference<String> assessmentResult = new AtomicReference<>("");
        levelResults.forEach(levelResult -> {
            boolean hasNotSatisfied = levelResult.getProcesses().stream().anyMatch(processResult -> processResult.getResult().equals("Não satisfeito"));
            if (hasNotSatisfied) {
                if (assessmentResult.get().equals("")) {
                    assessmentResult.set(String.format("Não atendeu aos requisitos de processos e capacidade do Modelo de Referência %s do %s.", referenceModel.getName(), levelResult.getClassification().getName()));
                }
            } else if (assessmentResult.get().equals("") || assessmentResult.get().startsWith("Atendeu")) {
                assessmentResult.set(String.format("Atendeu aos requisitos de processos e capacidade do Modelo de Referência %s do %s.", referenceModel.getName(), levelResult.getClassification().getName()));
            }
        });
        jsonAssessment.setAssessmentResult(assessmentResult.get());
        jsonAssessment.setLevelResults(levelResults);
        assessment.setJsonAssessment(jsonAssessment);
    }

    private Collection<CapacityLevel> getCapacityLevels(Collection<Classification> classifications, Collection<CapacityLevel> capacityLevels) {
        Collection<String> idsCapacityLevels = classifications.stream()
                .map(Classification::getCapacityLevels)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        return capacityLevels.stream()
                .filter(capacityLevel -> idsCapacityLevels.contains(capacityLevel.getIdCapacityLevel()))
                .collect(Collectors.toSet());
    }

    private Collection<Classification> getClassifications(Classification targetLevel, MeasurementFramework measurementFramework) {
        List<Classification> classifications = new ArrayList<>(measurementFramework.getClassifications());
        int indexLevel = classifications.indexOf(targetLevel);
        return classifications.stream()
                .filter(classification -> classifications.indexOf(classification) <= indexLevel)
                .collect(Collectors.toList());
    }

    private Collection<?> getProcessByTargetLevel(Collection<Level> levels, ReferenceModel referenceModel) {
        return levels.stream().map(level -> {
            KnowledgeArea knowledgeAreaFromLevel = referenceModel.getKnowledgeAreas().stream()
                    .filter(knowledgeArea -> level.getIdProcessArea().equals(knowledgeArea.getIdKnowledgeArea()))
                    .findFirst().orElse(null);
            if (knowledgeAreaFromLevel != null) {
                Collection<Object> idsProcess = Arrays.asList(level.getValues());
                return knowledgeAreaFromLevel.getProcesses().stream()
                        .filter(process -> idsProcess.contains(process.getIdProcess()))
                        .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }).flatMap(Collection::stream).collect(Collectors.toList());
    }

}
