package br.com.tcc.services;

import br.com.tcc.dto.Evaluation;

import java.util.Collection;

public interface EvaluationService {

    Collection<Evaluation> list();

    Evaluation get(Integer idEvaluation);

    Integer register(Evaluation evaluation);

    Integer update(Integer idEvaluation, Evaluation evaluation);

    Integer delete(Integer idEvaluation);
}
