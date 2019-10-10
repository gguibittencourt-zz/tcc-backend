package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class MeasurementFrameworkConfig {

    private boolean isAccumulate;
    private Collection<Question> questions;
    private Collection<Goal> goals;
    private Collection<CapacityLevel> capacityLevels;
    private Collection<Rating> ratings;
    private Collection<Classification> classifications;

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

    public Collection<CapacityLevel> getCapacityLevels() {
        return capacityLevels;
    }

    public MeasurementFrameworkConfig setCapacityLevels(Collection<CapacityLevel> capacityLevels) {
        this.capacityLevels = capacityLevels;
        return this;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public MeasurementFrameworkConfig setRatings(Collection<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }

    public boolean isAccumulate() {
        return isAccumulate;
    }

    public MeasurementFrameworkConfig setAccumulate(boolean accumulate) {
        isAccumulate = accumulate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeasurementFrameworkConfig)) return false;
        MeasurementFrameworkConfig that = (MeasurementFrameworkConfig) o;
        return isAccumulate() == that.isAccumulate() &&
                Objects.equals(getQuestions(), that.getQuestions()) &&
                Objects.equals(getGoals(), that.getGoals()) &&
                Objects.equals(getCapacityLevels(), that.getCapacityLevels()) &&
                Objects.equals(getRatings(), that.getRatings()) &&
                Objects.equals(getClassifications(), that.getClassifications());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAccumulate(), getQuestions(), getGoals(), getCapacityLevels(), getRatings(), getClassifications());
    }
}
