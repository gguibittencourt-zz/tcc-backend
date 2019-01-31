package br.com.tcc.dto;

import java.util.Objects;

public class MeasurementFramework {

    private Integer idMeasurementFramework;
    private String name;
    private Integer idReferenceModel;

    public Integer getIdMeasurementFramework() {
        return idMeasurementFramework;
    }

    public MeasurementFramework setIdMeasurementFramework(Integer idMeasurementFramework) {
        this.idMeasurementFramework = idMeasurementFramework;
        return this;
    }

    public String getName() {
        return name;
    }

    public MeasurementFramework setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getIdReferenceModel() {
        return idReferenceModel;
    }

    public MeasurementFramework setIdReferenceModel(Integer idReferenceModel) {
        this.idReferenceModel = idReferenceModel;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeasurementFramework)) return false;
        MeasurementFramework that = (MeasurementFramework) o;
        return Objects.equals(getIdMeasurementFramework(), that.getIdMeasurementFramework()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getIdReferenceModel(), that.getIdReferenceModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMeasurementFramework(), getName(), getIdReferenceModel());
    }
}
