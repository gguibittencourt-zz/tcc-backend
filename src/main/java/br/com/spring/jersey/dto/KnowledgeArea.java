package br.com.spring.jersey.dto;

import java.util.Collection;

public class KnowledgeArea {

    private Integer idKnowledgeArea;
    private String name;
    private String purpose;
    private Collection<Process> processes;

    public Integer getIdKnowledgeArea() {
        return idKnowledgeArea;
    }

    public KnowledgeArea setIdKnowledgeArea(Integer idKnowledgeArea) {
        this.idKnowledgeArea = idKnowledgeArea;
        return this;
    }

    public String getName() {
        return name;
    }

    public KnowledgeArea setName(String name) {
        this.name = name;
        return this;
    }

    public String getPurpose() {
        return purpose;
    }

    public KnowledgeArea setPurpose(String purpose) {
        this.purpose = purpose;
        return this;
    }

    public Collection<Process> getProcesses() {
        return processes;
    }

    public KnowledgeArea setProcesses(Collection<Process> processes) {
        this.processes = processes;
        return this;
    }
}
