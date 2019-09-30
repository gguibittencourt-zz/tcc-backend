package br.com.tcc.dto;

import java.util.Arrays;
import java.util.Objects;

public class Goal {

    private String idGoal;
    private String idReference;
    private MetricScale[] metrics;

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

    public MetricScale[] getMetrics() {
        return metrics;
    }

    public Goal setMetrics(MetricScale[] metrics) {
        this.metrics = metrics;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goal)) return false;
        Goal goal = (Goal) o;
        return Objects.equals(getIdGoal(), goal.getIdGoal()) &&
                Objects.equals(getIdReference(), goal.getIdReference()) &&
                Arrays.equals(getMetrics(), goal.getMetrics());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getIdGoal(), getIdReference());
        result = 31 * result + Arrays.hashCode(getMetrics());
        return result;
    }
}
