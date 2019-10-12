package br.com.tcc.dao;

import br.com.tcc.dto.DataSource;

import java.util.Collection;

public interface DataSourceDAO {

    DataSource get(Integer idDataSource);

    Collection<DataSource> list(Integer idCompany);

    Integer register(DataSource dataSource);

    Integer update(Integer idDataSource, DataSource dataSource);

    Integer delete(Integer idDataSource);
}
