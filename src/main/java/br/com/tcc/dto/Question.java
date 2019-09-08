package br.com.tcc.dto;

import java.util.Objects;

public class Question {

    private String idQuestion;
    private String idProcess;
    private String idExpectedResult;
    private String idProcessAttribute;
    private String idProcessAttributeValue;
    private String name;
    private String tip;
    private String type;
    private Boolean required;
    private Object defaultValue;
    private Boolean dependsOnAnyQuestion;
    private String idDependentQuestion;
    private Object dependentValue;
    private Object updateValue;
    private QuestionConfig config;

    public String getIdQuestion() {
        return idQuestion;
    }

    public Question setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
        return this;
    }

    public String getIdProcess() {
        return idProcess;
    }

    public Question setIdProcess(String idProcess) {
        this.idProcess = idProcess;
        return this;
    }

    public String getIdProcessAttribute() {
        return idProcessAttribute;
    }

    public Question setIdProcessAttribute(String idProcessAttribute) {
        this.idProcessAttribute = idProcessAttribute;
        return this;
    }

    public String getIdProcessAttributeValue() {
        return idProcessAttributeValue;
    }

    public Question setIdProcessAttributeValue(String idProcessAttributeValue) {
        this.idProcessAttributeValue = idProcessAttributeValue;
        return this;
    }

    public String getIdExpectedResult() {
        return idExpectedResult;
    }

    public Question setIdExpectedResult(String idExpectedResult) {
        this.idExpectedResult = idExpectedResult;
        return this;
    }

    public String getName() {
        return name;
    }

    public Question setName(String name) {
        this.name = name;
        return this;
    }

    public String getTip() {
        return tip;
    }

    public Question setTip(String tip) {
        this.tip = tip;
        return this;
    }

    public String getType() {
        return type;
    }

    public Question setType(String type) {
        this.type = type;
        return this;
    }

    public Boolean getDependsOnAnyQuestion() {
        return dependsOnAnyQuestion;
    }

    public Question setDependsOnAnyQuestion(Boolean dependsOnAnyQuestion) {
        this.dependsOnAnyQuestion = dependsOnAnyQuestion;
        return this;
    }

    public String getIdDependentQuestion() {
        return idDependentQuestion;
    }

    public Question setIdDependentQuestion(String idDependentQuestion) {
        this.idDependentQuestion = idDependentQuestion;
        return this;
    }

    public QuestionConfig getConfig() {
        return config;
    }

    public Question setConfig(QuestionConfig config) {
        this.config = config;
        return this;
    }

    public Object getDependentValue() {
        return dependentValue;
    }

    public Question setDependentValue(Object dependentValue) {
        this.dependentValue = dependentValue;
        return this;
    }

    public Object getUpdateValue() {
        return updateValue;
    }

    public Question setUpdateValue(Object updateValue) {
        this.updateValue = updateValue;
        return this;
    }

    public Boolean getRequired() {
        return required;
    }

    public Question setRequired(Boolean required) {
        this.required = required;
        return this;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public Question setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return Objects.equals(getIdQuestion(), question.getIdQuestion()) &&
                Objects.equals(getIdProcess(), question.getIdProcess()) &&
                Objects.equals(getIdExpectedResult(), question.getIdExpectedResult()) &&
                Objects.equals(getIdProcessAttribute(), question.getIdProcessAttribute()) &&
                Objects.equals(getIdProcessAttributeValue(), question.getIdProcessAttributeValue()) &&
                Objects.equals(getName(), question.getName()) &&
                Objects.equals(getTip(), question.getTip()) &&
                Objects.equals(getType(), question.getType()) &&
                Objects.equals(getRequired(), question.getRequired()) &&
                Objects.equals(getDefaultValue(), question.getDefaultValue()) &&
                Objects.equals(getDependsOnAnyQuestion(), question.getDependsOnAnyQuestion()) &&
                Objects.equals(getIdDependentQuestion(), question.getIdDependentQuestion()) &&
                Objects.equals(getDependentValue(), question.getDependentValue()) &&
                Objects.equals(getUpdateValue(), question.getUpdateValue()) &&
                Objects.equals(getConfig(), question.getConfig());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdQuestion(), getIdProcess(), getIdExpectedResult(), getIdProcessAttribute(), getIdProcessAttributeValue(), getName(), getTip(), getType(), getRequired(), getDefaultValue(), getDependsOnAnyQuestion(), getIdDependentQuestion(), getDependentValue(), getUpdateValue(), getConfig());
    }
}
