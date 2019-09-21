package br.com.tcc.dto;

import java.util.Objects;

public class ExpectedResult {

    private String idExpectedResult;
    private String name;
    private Rating ratingAssessment;

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

    public Rating getRatingAssessment() {
        return ratingAssessment;
    }

    public ExpectedResult setRatingAssessment(Rating ratingAssessment) {
        this.ratingAssessment = ratingAssessment;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpectedResult)) return false;
        ExpectedResult that = (ExpectedResult) o;
        return Objects.equals(getIdExpectedResult(), that.getIdExpectedResult()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getRatingAssessment(), that.getRatingAssessment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdExpectedResult(), getName(), getRatingAssessment());
    }
}
