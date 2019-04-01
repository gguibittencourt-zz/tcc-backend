package br.com.tcc.dao.impl;

import br.com.tcc.dao.MeasurementFrameworkDAO;
import br.com.tcc.dao.metadata.Tables;
import br.com.tcc.dto.KnowledgeArea;
import br.com.tcc.dto.MeasurementFramework;
import br.com.tcc.dto.MeasurementFrameworkConfig;
import br.com.tcc.dto.Question;
import br.com.tcc.util.Constants;
import com.google.gson.Gson;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class MeasurementFrameworkDAOImpl implements MeasurementFrameworkDAO {

    private final DSLContext dslContext;
    private static final Gson GSON = new Gson();

    @Autowired
    public MeasurementFrameworkDAOImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public Collection<MeasurementFramework> list() {
        return this.dslContext
                .selectFrom(Tables.MEASUREMENT_FRAMEWORK)
                .fetch()
                .map(this::template);
    }


    @Override
    public MeasurementFramework get(Integer idMeasurementFramework) {
        return this.dslContext
                .selectFrom(Tables.MEASUREMENT_FRAMEWORK)
                .where(Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK.eq(idMeasurementFramework))
                .fetchOne()
                .map(this::template);
    }

    @Override
    public Integer register(MeasurementFramework measurementFramework) {
        MeasurementFrameworkConfig config = new MeasurementFrameworkConfig()
                .setQuestions(measurementFramework.getQuestions())
                .setGoals(measurementFramework.getGoals());
        return this.dslContext
                .insertInto(Tables.MEASUREMENT_FRAMEWORK)
                .set(Tables.MEASUREMENT_FRAMEWORK.NAME, measurementFramework.getName())
                .set(Tables.MEASUREMENT_FRAMEWORK.ID_REFERENCE_MODEL, measurementFramework.getIdReferenceModel())
                .set(Tables.MEASUREMENT_FRAMEWORK.JSON_MEASUREMENT_FRAMEWORK, GSON.toJson(config))
                .returning(Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK)
                .fetchOne().getIdMeasurementFramework();
    }

    @Override
    public Integer update(Integer idMeasurementFramework, MeasurementFramework measurementFramework) {
        MeasurementFrameworkConfig config = new MeasurementFrameworkConfig()
                .setQuestions(measurementFramework.getQuestions())
                .setGoals(measurementFramework.getGoals());
        return this.dslContext
                .update(Tables.MEASUREMENT_FRAMEWORK)
                .set(Tables.MEASUREMENT_FRAMEWORK.NAME, measurementFramework.getName())
                .set(Tables.MEASUREMENT_FRAMEWORK.ID_REFERENCE_MODEL, measurementFramework.getIdReferenceModel())
                .set(Tables.MEASUREMENT_FRAMEWORK.JSON_MEASUREMENT_FRAMEWORK, GSON.toJson(config))
                .where(Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK.eq(idMeasurementFramework))
                .execute();
    }

    @Override
    public Integer delete(Integer idMeasurementFramework) {
        return this.dslContext
                .deleteFrom(Tables.MEASUREMENT_FRAMEWORK)
                .where(Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK.eq(idMeasurementFramework))
                .execute();
    }

    @Override
    public Collection<MeasurementFramework> listByIds(Collection<Integer> idsMeasurementFramework) {
        return this.dslContext
                .selectFrom(Tables.MEASUREMENT_FRAMEWORK)
                .where(Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK.in(idsMeasurementFramework))
                .fetch()
                .map(this::template);
    }

    private MeasurementFramework template(Record measurementFrameworkRecord) {
        MeasurementFrameworkConfig config = GSON.fromJson(String.valueOf(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.JSON_MEASUREMENT_FRAMEWORK)), MeasurementFrameworkConfig.class);
        return new MeasurementFramework()
                .setIdMeasurementFramework(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK))
                .setIdReferenceModel(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.ID_REFERENCE_MODEL))
                .setName(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.NAME))
                .setQuestions(config.getQuestions())
                .setGoals(config.getGoals());
    }
}