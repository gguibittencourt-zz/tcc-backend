package br.com.tcc.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class ProcessResult {
    private Process process;
    private Collection<Result> resultsWithError;
    private Collection<CapacityResult> capacityResults;

    public Process getProcess() {
        return process;
    }

    public ProcessResult setProcess(Process process) {
        this.process = process;
        return this;
    }

    public ProcessResult setCapacityResults(Collection<CapacityResult> capacityResult) {
        this.capacityResults = capacityResult;
        return this;
    }

    public Collection<Result> getResultsWithError() {
        if (this.resultsWithError == null) {
            this.resultsWithError = new ArrayList<>();
        }
        return resultsWithError;
    }

    public ProcessResult setResultsWithError(Collection<Result> resultsWithError) {
        this.resultsWithError = resultsWithError;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessResult)) return false;
        ProcessResult that = (ProcessResult) o;
        return Objects.equals(getProcess(), that.getProcess()) &&
                Objects.equals(getResultsWithError(), that.getResultsWithError()) &&
                Objects.equals(capacityResults, that.capacityResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProcess(), getResultsWithError(), capacityResults);
    }
}
