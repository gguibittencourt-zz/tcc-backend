package br.com.tcc.dto;

import java.util.Arrays;
import java.util.Objects;

public class Level {
    private String idProcessArea;
    private Object[] values;

    public String getIdProcessArea() {
        return idProcessArea;
    }

    public Level setIdProcessArea(String idProcessArea) {
        this.idProcessArea = idProcessArea;
        return this;
    }

    public Object[] getValues() {
        return values;
    }

    public Level setValues(Object[] values) {
        this.values = values;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Level)) return false;
        Level level = (Level) o;
        return Objects.equals(getIdProcessArea(), level.getIdProcessArea()) &&
                Arrays.equals(getValues(), level.getValues());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getIdProcessArea());
        result = 31 * result + Arrays.hashCode(getValues());
        return result;
    }
}
