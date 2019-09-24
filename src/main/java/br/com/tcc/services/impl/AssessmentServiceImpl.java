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
            assessment.setIdAssessment(this.register(assessment));
        }
        return assessment;
    }

    private void checkMaturity(Assessment assessment) {
        JsonAssessment jsonAssessment = assessment.getJsonAssessment();
        Classification targetLevel = jsonAssessment.getTargetLevel();
        MeasurementFramework measurementFramework = jsonAssessment.getMeasurementFramework();
        ReferenceModel referenceModel = jsonAssessment.getReferenceModel();
        List<Classification> classifications = this.getClassifications(targetLevel, measurementFramework);
        Collection<Process> processesOfClassifications = this.getProcessOfClassifications(classifications, referenceModel);
        Collection<Result> resultsOfProcesses = this.getResultsOfProcesses(processesOfClassifications, jsonAssessment.getResults());
        List<LevelResult> levelResults = classifications.stream().map(classification -> {
            List<ProcessResult> processResults = processesOfClassifications.stream().map(process -> {
                ProcessResult processResult = new ProcessResult();
                Collection<CapacityLevel> capacityLevels = this.getCapacityLevels(classification, measurementFramework.getCapacityLevels());
                Collection<CapacityResult> capacityResults = capacityLevels.stream().map(capacityLevel -> {
                    CapacityResult capacityResult = new CapacityResult();
                    Collection<ProcessAttributeResult> processAttributeResults = capacityLevel.getProcessAttributes().stream().map(processAttribute -> {
                        ProcessAttributeResult processAttributeResult = new ProcessAttributeResult();
                        Rating ratingProcessAttributeByTotalValue = this.getRatingByProcessAttribute(measurementFramework, resultsOfProcesses, process, processAttribute);
                        processAttributeResult.setProcessAttribute(processAttribute);
                        processAttributeResult.setRating(ratingProcessAttributeByTotalValue);
                        return processAttributeResult;
                    }).collect(Collectors.toList());
                    capacityResult.setCapacityLevel(capacityLevel);
                    capacityResult.setProcessAttributeResults(processAttributeResults);
                    return capacityResult;
                }).collect(Collectors.toList());
                processResult.setCapacityResults(capacityResults);
                processResult.setProcess(process);
                return processResult;
            }).collect(Collectors.toList());

            LevelResult levelResult = new LevelResult();
            levelResult.setClassification(classification);
            levelResult.setProcesses(processResults);
            return levelResult;
        }).collect(Collectors.toList());
        levelResults.forEach(levelResult -> {
            Map<Process, Set<ProcessResult>> processResultsByProcessToBeCompleted = levelResults.stream().filter(levelResultToBeComplete -> levelResults.indexOf(levelResultToBeComplete) > levelResults.indexOf(levelResult))
                    .map(LevelResult::getProcesses)
                    .flatMap(Collection::stream)
                    .collect(Collectors.groupingBy(ProcessResult::getProcess, Collectors.toSet()));
            levelResult.getProcesses().forEach(processResult -> {
                boolean hasAnyProcessAttributeNotSatisfied = processResult.getCapacityResults().stream()
                        .anyMatch(capacityResult -> capacityResult.getProcessAttributeResults().stream()
                                .anyMatch(processAttributeResult -> !processAttributeResult.getProcessAttribute().getRatings().contains(processAttributeResult.getRating().getId())));
                if (hasAnyProcessAttributeNotSatisfied) {
                    processResult.setResult("Não satisfeito");
                } else {
                    Set<ProcessResult> processResults = processResultsByProcessToBeCompleted.get(processResult.getProcess());
                    if (processResults != null) {
                        boolean completed = processResults.stream()
                                .allMatch(processResultToBeCompleted -> processResultToBeCompleted.getCapacityResults().stream()
                                        .allMatch(capacityResultToBeCompleted -> capacityResultToBeCompleted.getProcessAttributeResults().stream()
                                                .allMatch(processAttributeResult -> processAttributeResult.getRating().getId().equals("4"))));
                        if (completed) {
                            processResult.setResult("Satisfeito");
                        } else {
                            processResult.setResult("Não satisfeito");
                        }
                    } else {
                        processResult.setResult("Satisfeito");
                    }
                }
            });
            boolean naoSatisfeito = levelResult.getProcesses().stream()
                    .anyMatch(processResult -> processResult.getResult().equals("Não satisfeito"));
            String result = String.format(" aos requisitos de processos e capacidade do Modelo de Referência: %s do %s", referenceModel.getName(), targetLevel.getName());
            levelResult.setResult(naoSatisfeito ?
                    "Não atendeu" + result :
                    "Atendeu" + result);
            Collections.reverse(levelResult.getProcesses());
        });
        levelResults.stream().filter(levelResult -> levelResult.getClassification().getIdClassification().equals(targetLevel.getIdClassification()))
                .findFirst().ifPresent(targetLevelResult -> jsonAssessment.setAssessmentResult(targetLevelResult.getResult()));
        Collections.reverse(levelResults);
        jsonAssessment.setLevelResults(levelResults);
    }

    private Rating getRatingByProcessAttribute(MeasurementFramework measurementFramework,
                                               Collection<Result> resultsOfProcesses,
                                               Process process,
                                               ProcessAttribute processAttribute) {
        if (processAttribute.getGenerateQuestions()) {
            AtomicReference<Float> valueResultProcess = new AtomicReference<>(0F);
            processAttribute.getValues().forEach(processAttributeValue -> {
                float totalValue = this.getTotalValueByProcessAttributeValue(measurementFramework, resultsOfProcesses, processAttributeValue.getIdProcessAttributeValue(), process.getIdProcess());
                Rating ratingByTotalValue = this.getRatingByTotalValue(totalValue, measurementFramework.getRatings());
                processAttributeValue.setRatingAssessment(ratingByTotalValue);
                if (ratingByTotalValue != null) {
                    valueResultProcess.updateAndGet(v -> v + ratingByTotalValue.getMaxValue());
                }
            });
            float totalValueProcessAttribute = valueResultProcess.get() / processAttribute.getValues().size();
            Rating ratingByTotalValue = this.getRatingByTotalValue(totalValueProcessAttribute, measurementFramework.getRatings());
            processAttribute.setRatingAssessment(ratingByTotalValue);
            return ratingByTotalValue;
        } else {
            AtomicReference<Float> valueResultProcess = new AtomicReference<>(0F);
            process.getExpectedResults().forEach(expectedResult -> {
                float totalValue = this.getTotalValueByExpectedResult(measurementFramework, resultsOfProcesses, expectedResult);
                Rating ratingByTotalValue = this.getRatingByTotalValue(totalValue, measurementFramework.getRatings());
                expectedResult.setRatingAssessment(ratingByTotalValue);
                if (ratingByTotalValue != null) {
                    valueResultProcess.updateAndGet(v -> v + ratingByTotalValue.getMaxValue());
                }
            });
            float totalValueProcess = valueResultProcess.get() / process.getExpectedResults().size();
            Rating ratingProcessByTotalValue = this.getRatingByTotalValue(totalValueProcess, measurementFramework.getRatings());
            process.setRatingProcessResult(ratingProcessByTotalValue);
            return ratingProcessByTotalValue;
        }
    }

    private float getTotalValueByExpectedResult(MeasurementFramework measurementFramework, Collection<Result> resultsOfProcesses, ExpectedResult expectedResult) {
        Collection<Result> resultsByExpectedResult = resultsOfProcesses.stream()
                .filter(result -> expectedResult.getIdExpectedResult().equals(result.getIdExpectedResult()))
                .collect(Collectors.toList());

        AtomicReference<Float> valueResult = new AtomicReference<>(0F);
        resultsByExpectedResult.forEach(result -> {
            measurementFramework.getRatings().stream().filter(rating -> rating.getId().equals(result.getValue()))
                    .findFirst()
                    .ifPresent(ratingOfExpectedResult -> valueResult.updateAndGet(v -> v + ratingOfExpectedResult.getMaxValue()));
        });
        return valueResult.get() / resultsByExpectedResult.size();
    }

    private float getTotalValueByProcessAttributeValue(MeasurementFramework measurementFramework,
                                                       Collection<Result> resultsOfProcesses,
                                                       String idProcessAttributeValue,
                                                       String idProcess) {
        Collection<Result> resultsByProcessAttributeValue = resultsOfProcesses.stream()
                .filter(result -> idProcessAttributeValue.equals(result.getIdProcessAttributeValue()) && idProcess.equals(result.getIdProcess()))
                .collect(Collectors.toList());

        AtomicReference<Float> valueResult = new AtomicReference<>(0F);
        resultsByProcessAttributeValue.forEach(result -> {
            measurementFramework.getRatings().stream().filter(rating -> rating.getId().equals(result.getValue()))
                    .findFirst()
                    .ifPresent(ratingOfExpectedResult -> valueResult.updateAndGet(v -> v + ratingOfExpectedResult.getMaxValue()));
        });
        return valueResult.get() / resultsByProcessAttributeValue.size();
    }

    private Collection<Result> getResultsOfProcesses(Collection<Process> processesOfClassifications, Collection<Result> results) {
        return results.stream()
                .filter(result -> processesOfClassifications.stream().anyMatch(process -> process.getIdProcess().equals(result.getIdProcess())))
                .collect(Collectors.toList());
    }

    private Collection<CapacityLevel> getCapacityLevels(Classification classification, Collection<CapacityLevel> capacityLevels) {
        return capacityLevels.stream()
                .filter(capacityLevel -> classification.getCapacityLevels().contains(capacityLevel.getIdCapacityLevel()))
                .collect(Collectors.toSet());
    }

    private List<Classification> getClassifications(Classification targetLevel, MeasurementFramework measurementFramework) {
        List<Classification> classifications = new ArrayList<>(measurementFramework.getClassifications());
        int indexLevel = classifications.indexOf(targetLevel);
        List<Classification> allClassifications = classifications.stream()
                .filter(classification -> classifications.indexOf(classification) <= indexLevel)
                .collect(Collectors.toList());
        Collections.reverse(allClassifications);
        return allClassifications;
    }

    @SuppressWarnings("unchecked")
    private Collection<Process> getProcessOfClassifications(Collection<Classification> classifications, ReferenceModel referenceModel) {
        Collection<?> processes = classifications.stream().map(classification -> classification.getLevels().stream().map(level -> {
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
        }).flatMap(Collection::stream).collect(Collectors.toSet())).flatMap(Collection::stream).collect(Collectors.toSet());
        return ((Collection<Process>) processes);
    }

    private Rating getRatingByTotalValue(Float totalValue, Collection<Rating> ratings) {
        return ratings.stream().filter(rating -> totalValue > rating.getMinValue() && totalValue <= rating.getMaxValue())
                .findFirst().orElse(null);
    }
}
