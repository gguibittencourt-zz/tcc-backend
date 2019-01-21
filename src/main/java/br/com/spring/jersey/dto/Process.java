package br.com.spring.jersey.dto;

public class Process {

    private String idProcess;
    private String name;
    private String purpose;

    public String getIdProcess() {
        return idProcess;
    }

    public Process setIdProcess(String idProcess) {
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
