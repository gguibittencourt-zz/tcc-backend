package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class CapacityLevel {
    private String idCapacityLevel;
    private String name;
    private Collection<ProcessAttribute> processAttributes;

    public String getIdCapacityLevel() {
        return idCapacityLevel;
    }

    public CapacityLevel setIdCapacityLevel(String idCapacityLevel) {
        this.idCapacityLevel = idCapacityLevel;
        return this;
    }

    public String getName() {
        return name;
    }

    public CapacityLevel setName(String name) {
        this.name = name;
        return this;
    }

    public Collection<ProcessAttribute> getProcessAttributes() {
        return processAttributes;
    }

    public CapacityLevel setProcessAttributes(Collection<ProcessAttribute> processAttributes) {
        this.processAttributes = processAttributes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CapacityLevel)) return false;
        CapacityLevel that = (CapacityLevel) o;
        return Objects.equals(getIdCapacityLevel(), that.getIdCapacityLevel()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getProcessAttributes(), that.getProcessAttributes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCapacityLevel(), getName(), getProcessAttributes());
    }
}
