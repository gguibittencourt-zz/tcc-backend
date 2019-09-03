package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class MeasurementFramework {

    private Integer idMeasurementFramework;
    private String name;
    private String type;
    private Integer idReferenceModel;
    private Collection<ScaleValues> scaleValues;
    private Collection<Question> questions;
    private Collection<Goal> goals;
    private Collection<ProcessAttribute> processAttributes;
    private Collection<Classification> classifications;

    public Integer getIdMeasurementFramework() {
        return idMeasurementFramework;
    }

    public MeasurementFramework setIdMeasurementFramework(Integer idMeasurementFramework) {
        this.idMeasurementFramework = idMeasurementFramework;
        return this;
    }

    public String getName() {
        return name;
    }

    public MeasurementFramework setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getIdReferenceModel() {
        return idReferenceModel;
    }

    public MeasurementFramework setIdReferenceModel(Integer idReferenceModel) {
        this.idReferenceModel = idReferenceModel;
        return this;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public MeasurementFramework setQuestions(Collection<Question> questions) {
        this.questions = questions;
        return this;
    }

    public Collection<Goal> getGoals() {
        return goals;
    }

    public MeasurementFramework setGoals(Collection<Goal> goals) {
        this.goals = goals;
        return this;
    }

    public String getType() {
        return type;
    }

    public MeasurementFramework setType(String type) {
        this.type = type;
        return this;
    }

    public Collection<Classification> getClassifications() {
        return classifications;
    }

    public MeasurementFramework setClassifications(Collection<Classification> classifications) {
        this.classifications = classifications;
        return this;
    }

    public Collection<ScaleValues> getScaleValues() {
        return scaleValues;
    }

    public MeasurementFramework setScaleValues(Collection<ScaleValues> scaleValues) {
        this.scaleValues = scaleValues;
        return this;
    }

    public Collection<ProcessAttribute> getProcessAttributes() {
        return processAttributes;
    }

    public MeasurementFramework setProcessAttributes(Collection<ProcessAttribute> processAttributes) {
        this.processAttributes = processAttributes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeasurementFramework)) return false;
        MeasurementFramework that = (MeasurementFramework) o;
        return Objects.equals(getIdMeasurementFramework(), that.getIdMeasurementFramework()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getIdReferenceModel(), that.getIdReferenceModel()) &&
                Objects.equals(getScaleValues(), that.getScaleValues()) &&
                Objects.equals(getQuestions(), that.getQuestions()) &&
                Objects.equals(getGoals(), that.getGoals()) &&
                Objects.equals(getProcessAttributes(), that.getProcessAttributes()) &&
                Objects.equals(getClassifications(), that.getClassifications());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMeasurementFramework(), getName(), getType(), getIdReferenceModel(), getScaleValues(), getQuestions(), getGoals(), getProcessAttributes(), getClassifications());
    }
}
