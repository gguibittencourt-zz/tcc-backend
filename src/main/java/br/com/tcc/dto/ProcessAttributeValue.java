package br.com.tcc.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProcessAttributeValue {

    private String idProcessAttributeValue;
    private String name;
    private Map<String, Rating> ratingAssessmentByIdProcess;

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

    public Map<String, Rating> getRatingAssessmentByIdProcess() {
        if (ratingAssessmentByIdProcess == null) {
            this.ratingAssessmentByIdProcess = new HashMap<>();
        }
        return ratingAssessmentByIdProcess;
    }

    public ProcessAttributeValue setRatingAssessmentByIdProcess(Map<String, Rating> ratingAssessmentByIdProcess) {
        this.ratingAssessmentByIdProcess = ratingAssessmentByIdProcess;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessAttributeValue)) return false;
        ProcessAttributeValue that = (ProcessAttributeValue) o;
        return Objects.equals(getIdProcessAttributeValue(), that.getIdProcessAttributeValue()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getRatingAssessmentByIdProcess(), that.getRatingAssessmentByIdProcess());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProcessAttributeValue(), getName(), getRatingAssessmentByIdProcess());
    }
}
