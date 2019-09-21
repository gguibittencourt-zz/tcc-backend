package br.com.tcc.dto;

import java.util.Objects;

public class ProcessAttributeResult {

    private ProcessAttribute processAttribute;
    private Rating rating;

    public ProcessAttribute getProcessAttribute() {
        return processAttribute;
    }

    public ProcessAttributeResult setProcessAttribute(ProcessAttribute processAttribute) {
        this.processAttribute = processAttribute;
        return this;
    }

    public Rating getRating() {
        return rating;
    }

    public ProcessAttributeResult setRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessAttributeResult)) return false;
        ProcessAttributeResult that = (ProcessAttributeResult) o;
        return Objects.equals(getProcessAttribute(), that.getProcessAttribute()) &&
                Objects.equals(getRating(), that.getRating());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProcessAttribute(), getRating());
    }
}
