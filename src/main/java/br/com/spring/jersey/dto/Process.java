package br.com.spring.jersey.dto;

public class Process {

    private Integer idProcess;
    private String name;
    private String purpose;

    public Integer getIdProcess() {
        return idProcess;
    }

    public Process setIdProcess(Integer idProcess) {
        this.idProcess = idProcess;
        return this;
    }

    public String getName() {
        return name;
    }

    public Process setName(String name) {
        this.name = name;
        return this;
    }

    public String getPurpose() {
        return purpose;
    }

    public Process setPurpose(String purpose) {
        this.purpose = purpose;
        return this;
    }
}
