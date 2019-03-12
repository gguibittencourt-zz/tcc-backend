package br.com.tcc.dto;

import java.util.Objects;

public class Goal {

    private String idGoal;
    private String idReference;
    private Float percentage;

    public String getIdGoal() {
        return idGoal;
    }

    public Goal setIdGoal(String idGoal) {
        this.idGoal = idGoal;
        return this;
    }

    public String getIdReference() {
        return idReference;
    }

    public Goal setIdReference(String idReference) {
        this.idReference = idReference;
        return this;
    }

    public Float getPercentage() {
        return percentage;
    }

    public Goal setPercentage(Float percentage) {
        this.percentage = percentage;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goal)) return false;
        Goal goal = (Goal) o;
        return Objects.equals(getIdGoal(), goal.getIdGoal()) &&
                Objects.equals(getIdReference(), goal.getIdReference()) &&
                Objects.equals(getPercentage(), goal.getPercentage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdGoal(), getIdReference(), getPercentage());
    }
}
