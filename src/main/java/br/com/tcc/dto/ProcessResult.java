package br.com.tcc.dto;

import java.util.Objects;

public class ProcessResult {
    private Process process;
    private String result;

    public Process getProcess() {
        return process;
    }

    public ProcessResult setProcess(Process process) {
        this.process = process;
        return this;
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
                Objects.equals(getResult(), that.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProcess(), getResult());
    }
}
