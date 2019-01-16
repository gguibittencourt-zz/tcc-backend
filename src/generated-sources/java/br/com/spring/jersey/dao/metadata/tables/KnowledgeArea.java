/*
 * This file is generated by jOOQ.
*/
package br.com.spring.jersey.dao.metadata.tables;


import br.com.spring.jersey.dao.metadata.App;
import br.com.spring.jersey.dao.metadata.Keys;
import br.com.spring.jersey.dao.metadata.tables.records.KnowledgeAreaRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class KnowledgeArea extends TableImpl<KnowledgeAreaRecord> {

    private static final long serialVersionUID = -1638880836;

    /**
     * The reference instance of <code>app.knowledge_area</code>
     */
    public static final KnowledgeArea KNOWLEDGE_AREA = new KnowledgeArea();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<KnowledgeAreaRecord> getRecordType() {
        return KnowledgeAreaRecord.class;
    }

    /**
     * The column <code>app.knowledge_area.id_knowledge_area</code>.
     */
    public final TableField<KnowledgeAreaRecord, Integer> ID_KNOWLEDGE_AREA = createField("id_knowledge_area", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>app.knowledge_area.name</code>.
     */
    public final TableField<KnowledgeAreaRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(200).nullable(false), this, "");

    /**
     * The column <code>app.knowledge_area.purpose</code>.
     */
    public final TableField<KnowledgeAreaRecord, String> PURPOSE = createField("purpose", org.jooq.impl.SQLDataType.VARCHAR.length(200), this, "");

    /**
     * The column <code>app.knowledge_area.json_knowledge_area</code>.
     */
    public final TableField<KnowledgeAreaRecord, Object> JSON_KNOWLEDGE_AREA = createField("json_knowledge_area", org.jooq.impl.DefaultDataType.getDefaultDataType("json"), this, "");

    /**
     * Create a <code>app.knowledge_area</code> table reference
     */
    public KnowledgeArea() {
        this("knowledge_area", null);
    }

    /**
     * Create an aliased <code>app.knowledge_area</code> table reference
     */
    public KnowledgeArea(String alias) {
        this(alias, KNOWLEDGE_AREA);
    }

    private KnowledgeArea(String alias, Table<KnowledgeAreaRecord> aliased) {
        this(alias, aliased, null);
    }

    private KnowledgeArea(String alias, Table<KnowledgeAreaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return App.APP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<KnowledgeAreaRecord, Integer> getIdentity() {
        return Keys.IDENTITY_KNOWLEDGE_AREA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<KnowledgeAreaRecord> getPrimaryKey() {
        return Keys.KEY_KNOWLEDGE_AREA_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<KnowledgeAreaRecord>> getKeys() {
        return Arrays.<UniqueKey<KnowledgeAreaRecord>>asList(Keys.KEY_KNOWLEDGE_AREA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KnowledgeArea as(String alias) {
        return new KnowledgeArea(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public KnowledgeArea rename(String name) {
        return new KnowledgeArea(name, null);
    }
}