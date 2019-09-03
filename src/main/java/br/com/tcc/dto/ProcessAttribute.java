package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class ProcessAttribute {

    private String idProcessAttribute;
    private String name;
    private String description;
    private Collection<ProcessAttributeValue> values;

    public String getIdProcessAttribute() {
        return idProcessAttribute;
    }

    public ProcessAttribute setIdProcessAttribute(String idProcessAttribute) {
        this.idProcessAttribute = idProcessAttribute;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProcessAttribute setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProcessAttribute setDescription(String description) {
        this.description = description;
        return this;
    }

    public Collection<ProcessAttributeValue> getValues() {
        return values;
    }

    public ProcessAttribute setValues(Collection<ProcessAttributeValue> values) {
        this.values = values;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessAttribute)) return false;
        ProcessAttribute that = (ProcessAttribute) o;
        return Objects.equals(getIdProcessAttribute(), that.getIdProcessAttribute()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getValues(), that.getValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProcessAttribute(), getName(), getDescription(), getValues());
    }
}
