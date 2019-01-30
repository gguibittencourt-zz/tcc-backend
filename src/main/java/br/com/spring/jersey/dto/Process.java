package br.com.spring.jersey.dto;

import java.util.Collection;
import java.util.Objects;

public class Process {

    private String idProcess;
    private String name;
    private String purpose;
    private Collection<ExpectedResult> expectedResults;

    public String getIdProcess() {
        return idProcess;
    }

    public Process setIdProcess(String idProcess) {
        this.idProcess = idProcess;
        return this;
    }

    public String getName() {
        return name;
    }

    public Process setName(String name) {
        this.name = name;
        return this;
    }

    public String getPurpose() {
        return purpose;
    }

    public Process setPurpose(String purpose) {
        this.purpose = purpose;
        return this;
    }

    public Collection<ExpectedResult> getExpectedResults() {
        return expectedResults;
    }

    public void setExpectedResults(Collection<ExpectedResult> expectedResults) {
        this.expectedResults = expectedResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Process)) return false;
        Process process = (Process) o;
        return Objects.equals(getIdProcess(), process.getIdProcess()) &&
                Objects.equals(getName(), process.getName()) &&
                Objects.equals(getPurpose(), process.getPurpose()) &&
                Objects.equals(getExpectedResults(), process.getExpectedResults());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProcess(), getName(), getPurpose(), getExpectedResults());
    }
}
