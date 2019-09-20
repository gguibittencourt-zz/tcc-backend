package br.com.tcc.dto;

import java.util.Objects;

public class Rating {
    private String id;
    private String name;
    private String mappedName;
    private Float maxValue;
    private Float minValue;

    public String getId() {
        return id;
    }

    public Rating setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Rating setName(String name) {
        this.name = name;
        return this;
    }

    public String getMappedName() {
        return mappedName;
    }

    public Rating setMappedName(String mappedName) {
        this.mappedName = mappedName;
        return this;
    }

    public Float getMaxValue() {
        return maxValue;
    }

    public Rating setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public Float getMinValue() {
        return minValue;
    }

    public Rating setMinValue(Float minValue) {
        this.minValue = minValue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        Rating rating = (Rating) o;
        return Objects.equals(getId(), rating.getId()) &&
                Objects.equals(getName(), rating.getName()) &&
                Objects.equals(getMappedName(), rating.getMappedName()) &&
                Objects.equals(getMaxValue(), rating.getMaxValue()) &&
                Objects.equals(getMinValue(), rating.getMinValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMappedName(), getMaxValue(), getMinValue());
    }
}
