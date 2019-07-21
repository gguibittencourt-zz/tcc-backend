package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class JsonAssessment {

    private MeasurementFramework measurementFramework;
    private ReferenceModel referenceModel;
    private Collection<Result> results;

    public MeasurementFramework getMeasurementFramework() {
        return measurementFramework;
    }

    public JsonAssessment setMeasurementFramework(MeasurementFramework measurementFramework) {
        this.measurementFramework = measurementFramework;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonAssessment)) return false;
        JsonAssessment that = (JsonAssessment) o;
        return Objects.equals(getMeasurementFramework(), that.getMeasurementFramework()) &&
                Objects.equals(getReferenceModel(), that.getReferenceModel()) &&
                Objects.equals(getResults(), that.getResults());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMeasurementFramework(), getReferenceModel(), getResults());
    }
}
