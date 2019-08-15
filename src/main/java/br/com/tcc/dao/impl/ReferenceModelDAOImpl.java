package br.com.tcc.dao.impl;

import br.com.tcc.dao.ReferenceModelDAO;
import br.com.tcc.dao.metadata.Tables;
import br.com.tcc.dto.KnowledgeArea;
import br.com.tcc.dto.ReferenceModel;
import br.com.tcc.util.Constants;
import com.google.gson.Gson;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record3;
import org.jooq.SelectSelectStep;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class ReferenceModelDAOImpl implements ReferenceModelDAO {

    private final DSLContext dslContext;
    private static final Gson GSON = new Gson();

    @Autowired
    public ReferenceModelDAOImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public Collection<ReferenceModel> list() {
        return this.getSelect()
                .from(Tables.REFERENCE_MODEL)
                .fetch()
                .map(this::template);
    }


    @Override
    public ReferenceModel get(Integer idReferenceModel) {
        return this.getSelect()
                .from(Tables.REFERENCE_MODEL)
                .where(Tables.REFERENCE_MODEL.ID_REFERENCE_MODEL.eq(idReferenceModel))
                .fetchOne()
                .map(this::template);
    }

    @Override
    public Integer register(ReferenceModel referenceModel) {
        return this.dslContext
                .insertInto(Tables.REFERENCE_MODEL)
                .set(Tables.REFERENCE_MODEL.NAME, referenceModel.getName())
                .set(Tables.REFERENCE_MODEL.KNOWLEDGE_AREAS, GSON.toJson(referenceModel.getKnowledgeAreas()))
                .returning(Tables.REFERENCE_MODEL.ID_REFERENCE_MODEL)
                .fetchOne().getIdReferenceModel();
    }

    @Override
    public Integer update(Integer idReferenceModel, ReferenceModel referenceModel) {
        return this.dslContext
                .update(Tables.REFERENCE_MODEL)
                .set(Tables.REFERENCE_MODEL.NAME, referenceModel.getName())
                .set(Tables.REFERENCE_MODEL.KNOWLEDGE_AREAS, GSON.toJson(referenceModel.getKnowledgeAreas()))
                .where(Tables.REFERENCE_MODEL.ID_REFERENCE_MODEL.eq(idReferenceModel))
                .execute();
    }

    @Override
    public Integer delete(Integer idReferenceModel) {
        return this.dslContext
                .deleteFrom(Tables.REFERENCE_MODEL)
                .where(Tables.REFERENCE_MODEL.ID_REFERENCE_MODEL.eq(idReferenceModel))
                .execute();
    }

    private SelectSelectStep<Record3<Integer, String, String>> getSelect() {
        return this.dslContext
                .select(
                        Tables.REFERENCE_MODEL.ID_REFERENCE_MODEL,
                        Tables.REFERENCE_MODEL.NAME,
                        DSL.field(
                                "cast({0} as CHAR CHARACTER SET utf8) COLLATE utf8_unicode_ci",
                                String.class,
                                Tables.REFERENCE_MODEL.KNOWLEDGE_AREAS
                        ).as(Tables.REFERENCE_MODEL.KNOWLEDGE_AREAS));
    }

    private ReferenceModel template(Record referenceModelRecord) {
        Collection<KnowledgeArea> knowledgeAreas = GSON.fromJson(String.valueOf(referenceModelRecord.get(Tables.REFERENCE_MODEL.KNOWLEDGE_AREAS)), Constants.KNOWLEDGE_AREA_LIST_TYPE);
        return new ReferenceModel()
                .setIdReferenceModel(referenceModelRecord.get(Tables.REFERENCE_MODEL.ID_REFERENCE_MODEL))
                .setName(referenceModelRecord.get(Tables.REFERENCE_MODEL.NAME))
                .setKnowledgeAreas(knowledgeAreas);
    }
}