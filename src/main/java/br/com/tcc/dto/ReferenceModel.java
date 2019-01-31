package br.com.tcc.dto;

import java.util.Collection;

public class ReferenceModel {

    private Integer idReferenceModel;
    private String name;
    private Collection<KnowledgeArea> knowledgeAreas;

    public Integer getIdReferenceModel() {
        return idReferenceModel;
    }

    public ReferenceModel setIdReferenceModel(Integer idReferenceModel) {
        this.idReferenceModel = idReferenceModel;
        return this;
    }

    public String getName() {
        return name;
    }

    public ReferenceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Collection<KnowledgeArea> getKnowledgeAreas() {
        return knowledgeAreas;
    }

    public ReferenceModel setKnowledgeAreas(Collection<KnowledgeArea> knowledgeAreas) {
        this.knowledgeAreas = knowledgeAreas;
        return this;
    }
}
