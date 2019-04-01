package br.com.tcc.dao.impl;

import br.com.tcc.dao.EvaluationDAO;
import br.com.tcc.dao.metadata.Tables;
import br.com.tcc.dto.Evaluation;
import br.com.tcc.dto.Result;
import br.com.tcc.util.Constants;
import com.google.gson.Gson;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class EvaluationDAOImpl implements EvaluationDAO {

    private final DSLContext dslContext;
    private static final Gson GSON = new Gson();

    @Autowired
    public EvaluationDAOImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public Collection<Evaluation> list() {
        return this.dslContext
                .selectFrom(Tables.EVALUATION)
                .fetch()
                .map(this::template);
    }


    @Override
    public Evaluation get(Integer idEvaluation) {
        return this.dslContext
                .selectFrom(Tables.EVALUATION)
                .where(Tables.EVALUATION.ID_EVALUATION.eq(idEvaluation))
                .fetchOne()
                .map(this::template);
    }

    @Override
    public Integer register(Evaluation evaluation) {
        return this.dslContext
                .insertInto(Tables.EVALUATION)
                .set(Tables.EVALUATION.ID_USER, evaluation.getIdUser())
                .set(Tables.EVALUATION.ID_MEASUREMENT_FRAMEWORK, evaluation.getIdMeasurementFramework())
                .set(Tables.EVALUATION.STATUS, evaluation.getStatus())
                .set(Tables.EVALUATION.DATE, evaluation.getDate())
                .set(Tables.EVALUATION.JSON_EVALUATION, GSON.toJson(evaluation.getResults()))
                .returning(Tables.EVALUATION.ID_EVALUATION)
                .fetchOne().getIdEvaluation();
    }

    @Override
    public Integer update(Integer idEvaluation, Evaluation evaluation) {
        return this.dslContext
                .update(Tables.EVALUATION)
                .set(Tables.EVALUATION.ID_USER, evaluation.getIdUser())
                .set(Tables.EVALUATION.ID_MEASUREMENT_FRAMEWORK, evaluation.getIdMeasurementFramework())
                .set(Tables.EVALUATION.STATUS, evaluation.getStatus())
                .set(Tables.EVALUATION.DATE, evaluation.getDate())
                .set(Tables.EVALUATION.JSON_EVALUATION, GSON.toJson(evaluation.getResults()))
                .where(Tables.EVALUATION.ID_EVALUATION.eq(idEvaluation))
                .execute();
    }

    @Override
    public Integer delete(Integer idEvaluation) {
        return this.dslContext
                .deleteFrom(Tables.EVALUATION)
                .where(Tables.EVALUATION.ID_EVALUATION.eq(idEvaluation))
                .execute();
    }

    private Evaluation template(Record measurementFrameworkRecord) {
        Collection<Result> results = GSON.fromJson(String.valueOf(measurementFrameworkRecord.get(Tables.EVALUATION.JSON_EVALUATION)), Constants.RESULT_LIST_TYPE);
        return new Evaluation()
                .setIdEvaluation(measurementFrameworkRecord.get(Tables.EVALUATION.ID_EVALUATION))
                .setIdMeasurementFramework(measurementFrameworkRecord.get(Tables.EVALUATION.ID_MEASUREMENT_FRAMEWORK))
                .setIdUser(measurementFrameworkRecord.get(Tables.EVALUATION.ID_USER))
                .setStatus(measurementFrameworkRecord.get(Tables.EVALUATION.STATUS))
                .setDate(measurementFrameworkRecord.get(Tables.EVALUATION.DATE))
                .setResults(results);
    }
}