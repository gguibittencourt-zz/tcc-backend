package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class Process {

    private String idProcess;
    private String name;
    private String prefix;
    private String purpose;
    private Collection<ExpectedResult> expectedResults;
    private Rating ratingProcessResult;

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

    public String getPrefix() {
        return prefix;
    }

    public Process setPrefix(String prefix) {
        this.prefix = prefix;
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

    public Rating getRatingProcessResult() {
        return ratingProcessResult;
    }

    public Process setRatingProcessResult(Rating ratingProcessResult) {
        this.ratingProcessResult = ratingProcessResult;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Process)) return false;
        Process process = (Process) o;
        return Objects.equals(getIdProcess(), process.getIdProcess()) &&
                Objects.equals(getName(), process.getName()) &&
                Objects.equals(getPrefix(), process.getPrefix()) &&
                Objects.equals(getPurpose(), process.getPurpose()) &&
                Objects.equals(getExpectedResults(), process.getExpectedResults()) &&
                Objects.equals(getRatingProcessResult(), process.getRatingProcessResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProcess(), getName(), getPrefix(), getPurpose(), getExpectedResults(), getRatingProcessResult());
    }
}
