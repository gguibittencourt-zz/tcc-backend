package br.com.tcc.dto;

import java.util.Objects;

public class Question {

    private String idQuestion;
    private String idProcess;
    private String idExpectedResult;
    private String name;
    private String tip;
    private String type;
    private Boolean dependsOnAnyQuestion;
    private String idDependentQuestion;
    private Boolean hasDataSource;
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

    public Boolean getHasDataSource() {
        return hasDataSource;
    }

    public Question setHasDataSource(Boolean hasDataSource) {
        this.hasDataSource = hasDataSource;
        return this;
    }

    public QuestionConfig getConfig() {
        return config;
    }

    public Question setConfig(QuestionConfig config) {
        this.config = config;
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
                Objects.equals(getName(), question.getName()) &&
                Objects.equals(getTip(), question.getTip()) &&
                Objects.equals(getType(), question.getType()) &&
                Objects.equals(getDependsOnAnyQuestion(), question.getDependsOnAnyQuestion()) &&
                Objects.equals(getIdDependentQuestion(), question.getIdDependentQuestion()) &&
                Objects.equals(getHasDataSource(), question.getHasDataSource()) &&
                Objects.equals(getConfig(), question.getConfig());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdQuestion(), getIdProcess(), getIdExpectedResult(), getName(), getTip(), getType(), getDependsOnAnyQuestion(), getIdDependentQuestion(), getHasDataSource(), getConfig());
    }
}
