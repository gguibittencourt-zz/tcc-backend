package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class Classification {
    private String idClassification;
    private String name;
    private Collection<String> processAttributes;
    private Collection<Level> levels;

    public String getIdClassification() {
        return idClassification;
    }

    public Classification setIdClassification(String idClassification) {
        this.idClassification = idClassification;
        return this;
    }

    public String getName() {
        return name;
    }

    public Classification setName(String name) {
        this.name = name;
        return this;
    }

    public Collection<Level> getLevels() {
        return levels;
    }

    public Classification setLevels(Collection<Level> levels) {
        this.levels = levels;
        return this;
    }

    public Collection<String> getProcessAttributes() {
        return processAttributes;
    }

    public Classification setProcessAttributes(Collection<String> processAttributes) {
        this.processAttributes = processAttributes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classification)) return false;
        Classification that = (Classification) o;
        return Objects.equals(getIdClassification(), that.getIdClassification()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getProcessAttributes(), that.getProcessAttributes()) &&
                Objects.equals(getLevels(), that.getLevels());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdClassification(), getName(), getProcessAttributes(), getLevels());
    }
}
