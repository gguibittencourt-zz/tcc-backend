package br.com.tcc.services;

import br.com.tcc.dto.Assessment;

import java.util.Collection;

public interface AssessmentService {

    Collection<Assessment> list();

    Assessment get(Integer idAssessment);

    Integer register(Assessment assessment);

    Integer update(Integer idAssessment, Assessment assessment);

    Integer delete(Integer idAssessment);

    Assessment finish(Assessment assessment);
}
