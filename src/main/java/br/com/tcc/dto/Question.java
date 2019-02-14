package br.com.tcc.dto;

import java.util.Objects;

public class Question {

    private String idQuestion;
    private String idProcess;
    private String idExpectedResult;
    private String name;
    private String tip;
    private Boolean dependsOnAnyQuestion;

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

    public Boolean getDependsOnAnyQuestion() {
        return dependsOnAnyQuestion;
    }

    public Question setDependsOnAnyQuestion(Boolean dependsOnAnyQuestion) {
        this.dependsOnAnyQuestion = dependsOnAnyQuestion;
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
                Objects.equals(getDependsOnAnyQuestion(), question.getDependsOnAnyQuestion());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdQuestion(), getIdProcess(), getIdExpectedResult(), getName(), getTip(), getDependsOnAnyQuestion());
    }
}
