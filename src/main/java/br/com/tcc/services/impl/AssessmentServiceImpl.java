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
        Collection<LevelResult> levelResults = new ArrayList<>();
        Classification targetLevel = jsonAssessment.getTargetLevel();
        MeasurementFramework measurementFramework = jsonAssessment.getMeasurementFramework();
        ReferenceModel referenceModel = jsonAssessment.getReferenceModel();
        Collection<Classification> classifications = this.getClassifications(targetLevel, measurementFramework);
        Collection<String> processAttributes = classifications.stream()
                .map(Classification::getProcessAttributes)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        classifications.forEach(classification -> {
            LevelResult levelResult = new LevelResult().setClassification(classification);
            Collection<Process> processes = ((Collection<Process>) this.getProcessByTargetLevel(classification.getLevels(), referenceModel));
            Collection<String> idsProcess = processes.stream().map(Process::getIdProcess).collect(Collectors.toList());
            measurementFramework.getProcessAttributes().forEach(processAttribute -> {
                if (processAttributes.contains(processAttribute.getIdProcessAttribute())) {
                    if (!processAttribute.getGenerateQuestions()) {
                        measurementFramework.getGoals().stream()
                                .filter(goal -> idsProcess.contains(goal.getIdReference()))
                                .forEach(goal -> {
                                    Process processToResult = processes.stream().filter(process -> process.getIdProcess().equals(goal.getIdReference())).findFirst().orElse(null);
                                    ProcessResult processResult = new ProcessResult().setProcess(processToResult);
                                    Collection<Result> results = jsonAssessment.getResults().stream()
                                            .filter(result -> result.getIdProcess().equals(goal.getIdReference()) && result.getIdProcessAttribute().equals(""))
                                            .collect(Collectors.toList());
                                    Collection<String> valuesToResult = goal.getMetrics()[0].getValues().stream()
                                            .map(MetricScale::getIdMetricScale)
                                            .collect(Collectors.toList());
                                    Collection<Result> resultsWithError = results.stream()
                                            .filter(result -> !valuesToResult.contains(result.getValue()))
                                            .collect(Collectors.toList());
                                    processResult.setResult(resultsWithError.isEmpty() ? "Satisfeito" : "Não satisfeito");
                                    processResult.setResultsWithError(resultsWithError);
                                    levelResult.getProcesses().add(processResult);
                                });
                    } else {
                        levelResult.getProcesses().forEach(processResult -> {
                            Collection<Result> results = jsonAssessment.getResults().stream()
                                    .filter(result -> result.getIdProcessAttribute().equals(processAttribute.getIdProcessAttribute()) &&
                                            processResult.getProcess().getIdProcess().equals(result.getIdProcess()))
                                    .collect(Collectors.toList());
                            Collection<Result> resultsWithError = results.stream()
                                    .filter(result -> !result.getValue().equals("5"))
                                    .collect(Collectors.toList());
                            processResult.getResultsWithError().addAll(resultsWithError);
                             if (!resultsWithError.isEmpty() && processResult.getResult().equals("Satisfeito")) {
                                processResult.setResult("Não satisfeito");
                            }
                        });
                    }
                }
            });
            levelResults.add(levelResult);
        });

        jsonAssessment.setLevelResults(levelResults);
        assessment.setJsonAssessment(jsonAssessment);
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
