package br.com.tcc.dto;

import java.util.Objects;

public class Result {

    private String idResult;
    private String idKnowledgeArea;
    private String idProcess;
    private String idExpectedResult;
    private String idProcessAttribute;
    private String idProcessAttributeValue;
    private String idQuestion;
    private String value;

    public String getIdResult() {
        return idResult;
    }

    public Result setIdResult(String idResult) {
        this.idResult = idResult;
        return this;
    }

    public String getIdKnowledgeArea() {
        return idKnowledgeArea;
    }

    public Result setIdKnowledgeArea(String idKnowledgeArea) {
        this.idKnowledgeArea = idKnowledgeArea;
        return this;
    }

    public String getIdProcess() {
        return idProcess;
    }

    public Result setIdProcess(String idProcess) {
        this.idProcess = idProcess;
        return this;
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public Result setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Result setValue(String value) {
        this.value = value;
        return this;
    }

    public String getIdExpectedResult() {
        return idExpectedResult;
    }

    public Result setIdExpectedResult(String idExpectedResult) {
        this.idExpectedResult = idExpectedResult;
        return this;
    }

    public String getIdProcessAttribute() {
        return idProcessAttribute;
    }

    public Result setIdProcessAttribute(String idProcessAttribute) {
        this.idProcessAttribute = idProcessAttribute;
        return this;
    }

    public String getIdProcessAttributeValue() {
        return idProcessAttributeValue;
    }

    public Result setIdProcessAttributeValue(String idProcessAttributeValue) {
        this.idProcessAttributeValue = idProcessAttributeValue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return Objects.equals(getIdResult(), result.getIdResult()) &&
                Objects.equals(getIdKnowledgeArea(), result.getIdKnowledgeArea()) &&
                Objects.equals(getIdProcess(), result.getIdProcess()) &&
                Objects.equals(getIdExpectedResult(), result.getIdExpectedResult()) &&
                Objects.equals(getIdProcessAttribute(), result.getIdProcessAttribute()) &&
                Objects.equals(getIdProcessAttributeValue(), result.getIdProcessAttributeValue()) &&
                Objects.equals(getIdQuestion(), result.getIdQuestion()) &&
                Objects.equals(getValue(), result.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdResult(), getIdKnowledgeArea(), getIdProcess(), getIdExpectedResult(), getIdProcessAttribute(), getIdProcessAttributeValue(), getIdQuestion(), getValue());
    }
}