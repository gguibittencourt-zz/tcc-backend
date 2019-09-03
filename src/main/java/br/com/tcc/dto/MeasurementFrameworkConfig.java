package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class MeasurementFrameworkConfig {

    private Collection<Question> questions;
    private Collection<Goal> goals;
    private Collection<ProcessAttribute> processAttributes;
    private Collection<Classification> classifications;
    private Collection<ScaleValues> scaleValues;

    public Collection<Question> getQuestions() {
        return questions;
    }

    public MeasurementFrameworkConfig setQuestions(Collection<Question> questions) {
        this.questions = questions;
        return this;
    }

    public Collection<Goal> getGoals() {
        return goals;
    }

    public MeasurementFrameworkConfig setGoals(Collection<Goal> goals) {
        this.goals = goals;
        return this;
    }

    public Collection<Classification> getClassifications() {
        return classifications;
    }

    public MeasurementFrameworkConfig setClassifications(Collection<Classification> classifications) {
        this.classifications = classifications;
        return this;
    }

    public Collection<ScaleValues> getScaleValues() {
        return scaleValues;
    }

    public MeasurementFrameworkConfig setScaleValues(Collection<ScaleValues> scaleValues) {
        this.scaleValues = scaleValues;
        return this;
    }

    public Collection<ProcessAttribute> getProcessAttributes() {
        return processAttributes;
    }

    public MeasurementFrameworkConfig setProcessAttributes(Collection<ProcessAttribute> processAttributes) {
        this.processAttributes = processAttributes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeasurementFrameworkConfig)) return false;
        MeasurementFrameworkConfig that = (MeasurementFrameworkConfig) o;
        return Objects.equals(getQuestions(), that.getQuestions()) &&
                Objects.equals(getGoals(), that.getGoals()) &&
                Objects.equals(getProcessAttributes(), that.getProcessAttributes()) &&
                Objects.equals(getClassifications(), that.getClassifications()) &&
                Objects.equals(getScaleValues(), that.getScaleValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestions(), getGoals(), getProcessAttributes(), getClassifications(), getScaleValues());
    }
}
