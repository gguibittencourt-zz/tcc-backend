package br.com.tcc.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class ProcessResult {
    private Process process;
    private String result;
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

    public Collection<CapacityResult> getCapacityResults() {
        return capacityResults;
    }

    public String getResult() {
        return result;
    }

    public ProcessResult setResult(String result) {
        this.result = result;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessResult)) return false;
        ProcessResult that = (ProcessResult) o;
        return Objects.equals(getProcess(), that.getProcess()) &&
                Objects.equals(getResult(), that.getResult()) &&
                Objects.equals(getCapacityResults(), that.getCapacityResults());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProcess(), getResult(), getCapacityResults());
    }
}
