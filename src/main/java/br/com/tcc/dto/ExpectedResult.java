package br.com.tcc.dto;

import java.util.Objects;

public class ExpectedResult {

    private String idExpectedResult;
    private String name;
    private String description;


    public String getIdExpectedResult() {
        return idExpectedResult;
    }

    public void setIdExpectedResult(String idExpectedResult) {
        this.idExpectedResult = idExpectedResult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpectedResult)) return false;
        ExpectedResult that = (ExpectedResult) o;
        return Objects.equals(getIdExpectedResult(), that.getIdExpectedResult()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdExpectedResult(), getName(), getDescription());
    }
}
