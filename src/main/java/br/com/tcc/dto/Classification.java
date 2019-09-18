package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class Classification {
    private String idClassification;
    private String name;
    private Collection<String> capacityLevels;
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

    public Collection<String> getCapacityLevels() {
        return capacityLevels;
    }

    public Classification setCapacityLevels(Collection<String> capacityLevels) {
        this.capacityLevels = capacityLevels;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classification)) return false;
        Classification that = (Classification) o;
        return Objects.equals(getIdClassification(), that.getIdClassification()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCapacityLevels(), that.getCapacityLevels()) &&
                Objects.equals(getLevels(), that.getLevels());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdClassification(), getName(), getCapacityLevels(), getLevels());
    }
}
