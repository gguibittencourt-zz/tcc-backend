package br.com.tcc.dao;

import br.com.tcc.dto.Evaluation;

import java.util.Collection;

public interface EvaluationDAO {

    Collection<Evaluation> list();

    Evaluation get(Integer idEvaluation);

    Integer register(Evaluation evaluation);

    Integer update(Integer idEvaluation, Evaluation evaluation);

    Integer delete(Integer idEvaluation);
}
