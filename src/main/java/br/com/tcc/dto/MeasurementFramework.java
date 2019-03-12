package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class MeasurementFramework {

    private Integer idMeasurementFramework;
    private String name;
    private Integer idReferenceModel;
    private Collection<Question> questions;
    private Collection<Goal> goals;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeasurementFramework)) return false;
        MeasurementFramework that = (MeasurementFramework) o;
        return Objects.equals(getIdMeasurementFramework(), that.getIdMeasurementFramework()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getIdReferenceModel(), that.getIdReferenceModel()) &&
                Objects.equals(getQuestions(), that.getQuestions()) &&
                Objects.equals(getGoals(), that.getGoals());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMeasurementFramework(), getName(), getIdReferenceModel(), getQuestions(), getGoals());
    }
}
