package br.com.tcc.dto;

import java.util.Objects;

public class ProcessAttributeValue {

    private String idProcessAttributeValue;
    private String name;
    private Rating ratingAssessment;

    public String getIdProcessAttributeValue() {
        return idProcessAttributeValue;
    }

    public ProcessAttributeValue setIdProcessAttributeValue(String idProcessAttributeValue) {
        this.idProcessAttributeValue = idProcessAttributeValue;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProcessAttributeValue setName(String name) {
        this.name = name;
        return this;
    }

    public Rating getRatingAssessment() {
        return ratingAssessment;
    }

    public ProcessAttributeValue setRatingAssessment(Rating ratingAssessment) {
        this.ratingAssessment = ratingAssessment;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessAttributeValue)) return false;
        ProcessAttributeValue that = (ProcessAttributeValue) o;
        return Objects.equals(getIdProcessAttributeValue(), that.getIdProcessAttributeValue()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getRatingAssessment(), that.getRatingAssessment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProcessAttributeValue(), getName(), getRatingAssessment());
    }
}
