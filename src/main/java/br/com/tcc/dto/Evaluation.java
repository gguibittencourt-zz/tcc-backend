package br.com.tcc.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class Evaluation {

    private Integer idEvaluation;
    private LocalDateTime date;
    private Integer idUser;
    private String status;
    private Integer idMeasurementFramework;

    public Integer getIdEvaluation() {
        return idEvaluation;
    }

    public Evaluation setIdEvaluation(Integer idEvaluation) {
        this.idEvaluation = idEvaluation;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Evaluation setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Evaluation setIdUser(Integer idUser) {
        this.idUser = idUser;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Evaluation setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getIdMeasurementFramework() {
        return idMeasurementFramework;
    }

    public Evaluation setIdMeasurementFramework(Integer idMeasurementFramework) {
        this.idMeasurementFramework = idMeasurementFramework;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evaluation)) return false;
        Evaluation that = (Evaluation) o;
        return Objects.equals(getIdEvaluation(), that.getIdEvaluation()) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getIdUser(), that.getIdUser()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getIdMeasurementFramework(), that.getIdMeasurementFramework());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEvaluation(), getDate(), getIdUser(), getStatus(), getIdMeasurementFramework());
    }
}