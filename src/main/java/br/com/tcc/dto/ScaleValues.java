package br.com.tcc.dto;

import java.util.Objects;

public class ScaleValues {
    private Integer id;
    private String value;
    private String mappedValue;

    public Integer getId() {
        return id;
    }

    public ScaleValues setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public ScaleValues setValue(String value) {
        this.value = value;
        return this;
    }

    public String getMappedValue() {
        return mappedValue;
    }

    public ScaleValues setMappedValue(String mappedValue) {
        this.mappedValue = mappedValue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScaleValues)) return false;
        ScaleValues that = (ScaleValues) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getValue(), that.getValue()) &&
                Objects.equals(getMappedValue(), that.getMappedValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue(), getMappedValue());
    }
}
