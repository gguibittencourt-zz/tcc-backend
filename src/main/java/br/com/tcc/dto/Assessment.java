package br.com.tcc.dto;

import br.com.tcc.dao.metadata.enums.AssessmentStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class Assessment {

    private Integer idAssessment;
    private LocalDateTime date;
    private Integer idUser;
    private AssessmentStatus status;
    private JsonAssessment jsonAssessment;

    public Integer getIdAssessment() {
        return idAssessment;
    }

    public Assessment setIdAssessment(Integer idAssessment) {
        this.idAssessment = idAssessment;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Assessment setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Assessment setIdUser(Integer idUser) {
        this.idUser = idUser;
        return this;
    }

    public AssessmentStatus getStatus() {
        return status;
    }

    public Assessment setStatus(AssessmentStatus status) {
        this.status = status;
        return this;
    }

    public JsonAssessment getJsonAssessment() {
        return jsonAssessment;
    }

    public Assessment setJsonAssessment(JsonAssessment jsonAssessment) {
        this.jsonAssessment = jsonAssessment;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assessment)) return false;
        Assessment that = (Assessment) o;
        return Objects.equals(getIdAssessment(), that.getIdAssessment()) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getIdUser(), that.getIdUser()) &&
                getStatus() == that.getStatus() &&
                Objects.equals(getJsonAssessment(), that.getJsonAssessment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAssessment(), getDate(), getIdUser(), getStatus(), getJsonAssessment());
    }
}