package br.com.tcc.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class LevelResult {
    private Classification classification;
    private Collection<ProcessResult> processes;

    public Classification getClassification() {
        return classification;
    }

    public LevelResult setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    public Collection<ProcessResult> getProcesses() {
        if (this.processes == null) {
            this.processes= new ArrayList<>();
        }
        return processes;
    }

    public LevelResult setProcesses(Collection<ProcessResult> processes) {
        this.processes = processes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LevelResult)) return false;
        LevelResult that = (LevelResult) o;
        return Objects.equals(getClassification(), that.getClassification()) &&
                Objects.equals(getProcesses(), that.getProcesses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClassification(), getProcesses());
    }
}
