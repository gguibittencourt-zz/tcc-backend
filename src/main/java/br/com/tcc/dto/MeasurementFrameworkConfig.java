package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class MeasurementFrameworkConfig {

    private Collection<Question> questions;
    private Collection<Goal> goals;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeasurementFrameworkConfig)) return false;
        MeasurementFrameworkConfig that = (MeasurementFrameworkConfig) o;
        return Objects.equals(getQuestions(), that.getQuestions()) &&
                Objects.equals(getGoals(), that.getGoals());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestions(), getGoals());
    }
}
