package br.com.tcc.services.impl;

import br.com.tcc.dao.AssessmentDAO;
import br.com.tcc.dao.metadata.enums.AssessmentStatus;
import br.com.tcc.dto.Assessment;
import br.com.tcc.services.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentDAO assessmentDAO;

    @Autowired
    public AssessmentServiceImpl(AssessmentDAO assessmentDAO) {
        this.assessmentDAO = assessmentDAO;
    }

    @Override
    public Collection<Assessment> list() {
        return this.assessmentDAO.list();
    }

    @Override
    public Assessment get(Integer idAssessment) {
        return this.assessmentDAO.get(idAssessment);
    }

    @Override
    public Integer register(Assessment assessment) {
        assessment
                .setDate(LocalDateTime.now())
                .setStatus(assessment.getStatus() == null ? AssessmentStatus.in_progress : assessment.getStatus());
        return this.assessmentDAO.register(assessment);
    }

    @Override
    public Integer update(Integer idAssessment, Assessment assessment) {
        assessment.setDate(LocalDateTime.now());
        return this.assessmentDAO.update(idAssessment, assessment);
    }

    @Override
    public Integer delete(Integer idAssessment) {
        return this.assessmentDAO.delete(idAssessment);
    }

}
