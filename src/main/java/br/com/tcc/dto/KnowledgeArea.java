package br.com.tcc.dto;

import java.util.Collection;

public class KnowledgeArea {

    private String idKnowledgeArea;
    private String name;
    private String prefix;
    private Collection<Process> processes;

    public String getIdKnowledgeArea() {
        return idKnowledgeArea;
    }

    public KnowledgeArea setIdKnowledgeArea(String idKnowledgeArea) {
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

    public String getPrefix() {
        return prefix;
    }

    public KnowledgeArea setPrefix(String prefix) {
        this.prefix = prefix;
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
