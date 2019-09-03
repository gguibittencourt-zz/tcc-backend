package br.com.tcc.dao.impl;

import br.com.tcc.dao.MeasurementFrameworkDAO;
import br.com.tcc.dao.metadata.Tables;
import br.com.tcc.dto.MeasurementFramework;
import br.com.tcc.dto.MeasurementFrameworkConfig;
import com.google.gson.Gson;
import org.jooq.*;
import org.jooq.impl.DSL;
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
        return this.getSelect()
                .from(Tables.MEASUREMENT_FRAMEWORK)
                .fetch()
                .map(this::template);
    }


    @Override
    public MeasurementFramework get(Integer idMeasurementFramework) {
        return this.getSelect()
                .from(Tables.MEASUREMENT_FRAMEWORK)
                .where(Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK.eq(idMeasurementFramework))
                .fetchOne()
                .map(this::template);
    }

    @Override
    public Integer register(MeasurementFramework measurementFramework) {
        MeasurementFrameworkConfig config = new MeasurementFrameworkConfig()
                .setQuestions(measurementFramework.getQuestions())
                .setGoals(measurementFramework.getGoals())
                .setClassifications(measurementFramework.getClassifications())
                .setScaleValues(measurementFramework.getScaleValues());
        return this.dslContext
                .insertInto(Tables.MEASUREMENT_FRAMEWORK)
                .set(Tables.MEASUREMENT_FRAMEWORK.NAME, measurementFramework.getName())
                .set(Tables.MEASUREMENT_FRAMEWORK.TYPE, measurementFramework.getType())
                .set(Tables.MEASUREMENT_FRAMEWORK.ID_REFERENCE_MODEL, measurementFramework.getIdReferenceModel())
                .set(Tables.MEASUREMENT_FRAMEWORK.JSON_MEASUREMENT_FRAMEWORK, GSON.toJson(config))
                .returning(Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK)
                .fetchOne().getIdMeasurementFramework();
    }

    @Override
    public Integer update(Integer idMeasurementFramework, MeasurementFramework measurementFramework) {
        MeasurementFrameworkConfig config = new MeasurementFrameworkConfig()
                .setQuestions(measurementFramework.getQuestions())
                .setProcessAttributes(measurementFramework.getProcessAttributes())
                .setGoals(measurementFramework.getGoals())
                .setClassifications(measurementFramework.getClassifications())
                .setScaleValues(measurementFramework.getScaleValues());
        return this.dslContext
                .update(Tables.MEASUREMENT_FRAMEWORK)
                .set(Tables.MEASUREMENT_FRAMEWORK.NAME, measurementFramework.getName())
                .set(Tables.MEASUREMENT_FRAMEWORK.TYPE, measurementFramework.getType())
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

    private SelectSelectStep<Record5<Integer, String, String, Integer, String>> getSelect() {
        return this.dslContext
                .select(
                        Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK,
                        Tables.MEASUREMENT_FRAMEWORK.NAME,
                        Tables.MEASUREMENT_FRAMEWORK.TYPE,
                        Tables.MEASUREMENT_FRAMEWORK.ID_REFERENCE_MODEL,
                        DSL.field(
                                "cast({0} as CHAR CHARACTER SET utf8) COLLATE utf8_unicode_ci",
                                String.class,
                                Tables.MEASUREMENT_FRAMEWORK.JSON_MEASUREMENT_FRAMEWORK
                        ).as(Tables.MEASUREMENT_FRAMEWORK.JSON_MEASUREMENT_FRAMEWORK));
    }

    private MeasurementFramework template(Record measurementFrameworkRecord) {
        MeasurementFrameworkConfig config = GSON.fromJson(String.valueOf(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.JSON_MEASUREMENT_FRAMEWORK)), MeasurementFrameworkConfig.class);
        return new MeasurementFramework()
                .setIdMeasurementFramework(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK))
                .setIdReferenceModel(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.ID_REFERENCE_MODEL))
                .setName(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.NAME))
                .setType(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.TYPE))
                .setQuestions(config.getQuestions())
                .setProcessAttributes(config.getProcessAttributes())
                .setClassifications(config.getClassifications())
                .setGoals(config.getGoals())
                .setScaleValues(config.getScaleValues());
    }
}