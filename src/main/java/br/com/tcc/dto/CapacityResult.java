package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class CapacityResult {

    private CapacityLevel capacityLevel;
    private Collection<ProcessAttributeResult> processAttributeResults;

    public CapacityLevel getCapacityLevel() {
        return capacityLevel;
    }

    public CapacityResult setCapacityLevel(CapacityLevel capacityLevel) {
        this.capacityLevel = capacityLevel;
        return this;
    }

    public Collection<ProcessAttributeResult> getProcessAttributeResults() {
        return processAttributeResults;
    }

    public CapacityResult setProcessAttributeResults(Collection<ProcessAttributeResult> processAttributeResults) {
        this.processAttributeResults = processAttributeResults;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CapacityResult)) return false;
        CapacityResult that = (CapacityResult) o;
        return Objects.equals(getCapacityLevel(), that.getCapacityLevel()) &&
                Objects.equals(getProcessAttributeResults(), that.getProcessAttributeResults());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCapacityLevel(), getProcessAttributeResults());
    }
}
