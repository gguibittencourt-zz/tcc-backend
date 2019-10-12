package br.com.tcc.dao.impl;

import br.com.tcc.dao.DataSourceDAO;
import br.com.tcc.dao.metadata.Tables;
import br.com.tcc.dto.DataSource;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record7;
import org.jooq.SelectSelectStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class DataSourceDAOImpl implements DataSourceDAO {

    private final DSLContext dslContext;

    @Autowired
    public DataSourceDAOImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public Collection<DataSource> list(Integer idCompany) {
        return this.getSelect()
                .from(Tables.DATA_SOURCE)
                .fetch()
                .map(this::template);
    }


    @Override
    public DataSource get(Integer idDataSource) {
        return this.getSelect()
                .from(Tables.DATA_SOURCE)
                .where(Tables.DATA_SOURCE.ID_DATA_SOURCE.eq(idDataSource))
                .fetchOne()
                .map(this::template);
    }

    @Override
    public Integer register(DataSource dataSource) {
        return this.dslContext
                .insertInto(Tables.DATA_SOURCE)
                .set(Tables.DATA_SOURCE.NAME, dataSource.getName())
                .set(Tables.DATA_SOURCE.URL, dataSource.getUrl())
                .set(Tables.DATA_SOURCE.ID_COMPANY, dataSource.getIdCompany())
                .set(Tables.DATA_SOURCE.AUTHENTICATED, dataSource.getAuthenticated())
                .set(Tables.DATA_SOURCE.USER, dataSource.getUser())
                .set(Tables.DATA_SOURCE.PASSWORD, dataSource.getPassword())
                .returning(Tables.DATA_SOURCE.ID_DATA_SOURCE)
                .fetchOne().getIdDataSource();
    }

    @Override
    public Integer update(Integer idDataSource, DataSource dataSource) {
        return this.dslContext
                .update(Tables.DATA_SOURCE)
                .set(Tables.DATA_SOURCE.NAME, dataSource.getName())
                .set(Tables.DATA_SOURCE.URL, dataSource.getUrl())
                .set(Tables.DATA_SOURCE.ID_COMPANY, dataSource.getIdCompany())
                .set(Tables.DATA_SOURCE.AUTHENTICATED, dataSource.getAuthenticated())
                .set(Tables.DATA_SOURCE.USER, dataSource.getUser())
                .set(Tables.DATA_SOURCE.PASSWORD, dataSource.getPassword())
                .where(Tables.DATA_SOURCE.ID_DATA_SOURCE.eq(idDataSource))
                .execute();
    }

    @Override
    public Integer delete(Integer idDataSource) {
        return this.dslContext
                .deleteFrom(Tables.DATA_SOURCE)
                .where(Tables.DATA_SOURCE.ID_DATA_SOURCE.eq(idDataSource))
                .execute();
    }

    private SelectSelectStep<Record7<Integer, String, Integer, String, String, String, String>> getSelect() {
        return this.dslContext
                .select(
                        Tables.DATA_SOURCE.ID_DATA_SOURCE,
                        Tables.DATA_SOURCE.NAME,
                        Tables.DATA_SOURCE.ID_COMPANY,
                        Tables.DATA_SOURCE.URL,
                        Tables.DATA_SOURCE.AUTHENTICATED,
                        Tables.DATA_SOURCE.USER,
                        Tables.DATA_SOURCE.PASSWORD
                );
    }

    private DataSource template(Record dataSourceRecord) {
        return new DataSource()
                .setIdDataSource(dataSourceRecord.get(Tables.DATA_SOURCE.ID_DATA_SOURCE))
                .setName(dataSourceRecord.get(Tables.DATA_SOURCE.NAME))
                .setIdCompany(dataSourceRecord.get(Tables.DATA_SOURCE.ID_COMPANY))
                .setUrl(dataSourceRecord.get(Tables.DATA_SOURCE.URL))
                .setUser(dataSourceRecord.get(Tables.DATA_SOURCE.USER))
                .setPassword(dataSourceRecord.get(Tables.DATA_SOURCE.PASSWORD))
                .setAuthenticated(dataSourceRecord.get(Tables.DATA_SOURCE.AUTHENTICATED));
    }
}