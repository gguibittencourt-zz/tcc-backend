package br.com.tcc.dao.impl;

import br.com.tcc.dao.MeasurementFrameworkDAO;
import br.com.tcc.dao.metadata.Tables;
import br.com.tcc.dto.MeasurementFramework;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class MeasurementFrameworkDAOImpl implements MeasurementFrameworkDAO {

    private final DSLContext dslContext;

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
        return this.dslContext
                .insertInto(Tables.MEASUREMENT_FRAMEWORK)
                .set(Tables.MEASUREMENT_FRAMEWORK.NAME, measurementFramework.getName())
                .set(Tables.MEASUREMENT_FRAMEWORK.ID_REFERENCE_MODEL, measurementFramework.getIdReferenceModel())
                .returning(Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK)
                .fetchOne().getIdMeasurementFramework();
    }

    @Override
    public Integer update(Integer idMeasurementFramework, MeasurementFramework measurementFramework) {
        return this.dslContext
                .update(Tables.MEASUREMENT_FRAMEWORK)
                .set(Tables.MEASUREMENT_FRAMEWORK.NAME, measurementFramework.getName())
                .set(Tables.MEASUREMENT_FRAMEWORK.ID_REFERENCE_MODEL, measurementFramework.getIdReferenceModel())
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

    private MeasurementFramework template(Record measurementFrameworkRecord) {
        return new MeasurementFramework()
                .setIdMeasurementFramework(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.ID_MEASUREMENT_FRAMEWORK))
                .setIdReferenceModel(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.ID_REFERENCE_MODEL))
                .setName(measurementFrameworkRecord.get(Tables.MEASUREMENT_FRAMEWORK.NAME));
    }
}