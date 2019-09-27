package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class ProcessAttribute {

    private String idProcessAttribute;
    private String name;
    private String prefix;
    private String description;
    private Collection<ProcessAttributeValue> values;
    private Collection<String> ratings;
    private Rating ratingAssessment;

    public String getIdProcessAttribute() {
        return idProcessAttribute;
    }

    public ProcessAttribute setIdProcessAttribute(String idProcessAttribute) {
        this.idProcessAttribute = idProcessAttribute;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProcessAttribute setName(String name) {
        this.name = name;
        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public ProcessAttribute setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProcessAttribute setDescription(String description) {
        this.description = description;
        return this;
    }

    public Collection<ProcessAttributeValue> getValues() {
        return values;
    }

    public ProcessAttribute setValues(Collection<ProcessAttributeValue> values) {
        this.values = values;
        return this;
    }

    public Collection<String> getRatings() {
        return ratings;
    }

    public ProcessAttribute setRatings(Collection<String> ratings) {
        this.ratings = ratings;
        return this;
    }

    public Rating getRatingAssessment() {
        return ratingAssessment;
    }

    public ProcessAttribute setRatingAssessment(Rating ratingAssessment) {
        this.ratingAssessment = ratingAssessment;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessAttribute)) return false;
        ProcessAttribute that = (ProcessAttribute) o;
        return Objects.equals(getIdProcessAttribute(), that.getIdProcessAttribute()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPrefix(), that.getPrefix()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getValues(), that.getValues()) &&
                Objects.equals(getRatings(), that.getRatings()) &&
                Objects.equals(getRatingAssessment(), that.getRatingAssessment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProcessAttribute(), getName(), getPrefix(), getDescription(), getValues(), getRatings(), getRatingAssessment());
    }
}
