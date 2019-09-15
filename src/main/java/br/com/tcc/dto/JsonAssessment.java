package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class JsonAssessment {

    private MeasurementFramework measurementFramework;
    private Classification targetLevel;
    private ReferenceModel referenceModel;
    private Collection<Result> results;
    private Collection<LevelResult> levelResults;
    private Company company;
    private String assessmentResult;

    public MeasurementFramework getMeasurementFramework() {
        return measurementFramework;
    }

    public JsonAssessment setMeasurementFramework(MeasurementFramework measurementFramework) {
        this.measurementFramework = measurementFramework;
        return this;
    }

    public Classification getTargetLevel() {
        return targetLevel;
    }

    public JsonAssessment setTargetLevel(Classification targetLevel) {
        this.targetLevel = targetLevel;
        return this;
    }

    public ReferenceModel getReferenceModel() {
        return referenceModel;
    }

    public JsonAssessment setReferenceModel(ReferenceModel referenceModel) {
        this.referenceModel = referenceModel;
        return this;
    }

    public Collection<Result> getResults() {
        return results;
    }

    public JsonAssessment setResults(Collection<Result> results) {
        this.results = results;
        return this;
    }

    public Collection<LevelResult> getLevelResults() {
        return levelResults;
    }

    public JsonAssessment setLevelResults(Collection<LevelResult> levelResults) {
        this.levelResults = levelResults;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public JsonAssessment setCompany(Company company) {
        this.company = company;
        return this;
    }

    public String getAssessmentResult() {
        return assessmentResult;
    }

    public JsonAssessment setAssessmentResult(String assessmentResult) {
        this.assessmentResult = assessmentResult;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonAssessment)) return false;
        JsonAssessment that = (JsonAssessment) o;
        return Objects.equals(getMeasurementFramework(), that.getMeasurementFramework()) &&
                Objects.equals(getTargetLevel(), that.getTargetLevel()) &&
                Objects.equals(getReferenceModel(), that.getReferenceModel()) &&
                Objects.equals(getResults(), that.getResults()) &&
                Objects.equals(getLevelResults(), that.getLevelResults()) &&
                Objects.equals(getCompany(), that.getCompany()) &&
                Objects.equals(getAssessmentResult(), that.getAssessmentResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMeasurementFramework(), getTargetLevel(), getReferenceModel(), getResults(), getLevelResults(), getCompany(), getAssessmentResult());
    }
}
