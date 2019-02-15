package br.com.tcc.dto;

import java.util.Objects;

public class QuestionConfig {

    private Integer minCharacters;
    private Integer maxCharacters;
    private Float minValue;
    private Float maxValue;

    public Integer getMinCharacters() {
        return minCharacters;
    }

    public QuestionConfig setMinCharacters(Integer minCharacters) {
        this.minCharacters = minCharacters;
        return this;
    }

    public Integer getMaxCharacters() {
        return maxCharacters;
    }

    public QuestionConfig setMaxCharacters(Integer maxCharacters) {
        this.maxCharacters = maxCharacters;
        return this;
    }

    public Float getMinValue() {
        return minValue;
    }

    public QuestionConfig setMinValue(Float minValue) {
        this.minValue = minValue;
        return this;
    }

    public Float getMaxValue() {
        return maxValue;
    }

    public QuestionConfig setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionConfig)) return false;
        QuestionConfig that = (QuestionConfig) o;
        return Objects.equals(getMinCharacters(), that.getMinCharacters()) &&
                Objects.equals(getMaxCharacters(), that.getMaxCharacters()) &&
                Objects.equals(getMinValue(), that.getMinValue()) &&
                Objects.equals(getMaxValue(), that.getMaxValue());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMinCharacters(), getMaxCharacters(), getMinValue(), getMaxValue());
    }
}
