package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class ProcessAttributeValue {

    private String name;

    public String getName() {
        return name;
    }

    public ProcessAttributeValue setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessAttributeValue)) return false;
        ProcessAttributeValue that = (ProcessAttributeValue) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
