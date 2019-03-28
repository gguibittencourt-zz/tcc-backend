package br.com.tcc.services.impl;

import br.com.tcc.dao.EvaluationDAO;
import br.com.tcc.dto.Evaluation;
import br.com.tcc.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationDAO evaluationDAO;

    @Autowired
    public EvaluationServiceImpl(EvaluationDAO evaluationDAO) {
        this.evaluationDAO = evaluationDAO;
    }

    @Override
    public Collection<Evaluation> list() {
        return this.evaluationDAO.list();
    }

    @Override
    public Evaluation get(Integer idEvaluation) {
        return this.evaluationDAO.get(idEvaluation);
    }

    @Override
    public Integer register(Evaluation evaluation) {
        return this.evaluationDAO.register(evaluation);
    }

    @Override
    public Integer update(Integer idEvaluation, Evaluation evaluation) {
        return this.evaluationDAO.update(idEvaluation, evaluation);
    }

    @Override
    public Integer delete(Integer idEvaluation) {
        return this.evaluationDAO.delete(idEvaluation);
    }

}
