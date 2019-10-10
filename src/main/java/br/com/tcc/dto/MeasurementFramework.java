package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class MeasurementFramework {

    private Integer idMeasurementFramework;
    private String name;
    private String type;
    private Integer idReferenceModel;
    private Collection<Question> questions;
    private Collection<Goal> goals;
    private Collection<CapacityLevel> capacityLevels;
    private Collection<Classification> classifications;
    private Collection<Rating> ratings;
    private boolean isAccumulate;

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

    public Collection<CapacityLevel> getCapacityLevels() {
        return capacityLevels;
    }

    public MeasurementFramework setCapacityLevels(Collection<CapacityLevel> capacityLevels) {
        this.capacityLevels = capacityLevels;
        return this;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public MeasurementFramework setRatings(Collection<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }

    public boolean isAccumulate() {
        return isAccumulate;
    }

    public MeasurementFramework setAccumulate(boolean accumulate) {
        isAccumulate = accumulate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeasurementFramework)) return false;
        MeasurementFramework that = (MeasurementFramework) o;
        return isAccumulate() == that.isAccumulate() &&
                Objects.equals(getIdMeasurementFramework(), that.getIdMeasurementFramework()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getIdReferenceModel(), that.getIdReferenceModel()) &&
                Objects.equals(getQuestions(), that.getQuestions()) &&
                Objects.equals(getGoals(), that.getGoals()) &&
                Objects.equals(getCapacityLevels(), that.getCapacityLevels()) &&
                Objects.equals(getClassifications(), that.getClassifications()) &&
                Objects.equals(getRatings(), that.getRatings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMeasurementFramework(), getName(), getType(), getIdReferenceModel(), getQuestions(), getGoals(), getCapacityLevels(), getClassifications(), getRatings(), isAccumulate());
    }
}
