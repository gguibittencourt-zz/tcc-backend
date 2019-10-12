package br.com.tcc.services;

import br.com.tcc.dto.DataSource;

import java.util.Collection;

public interface DataSourceService {

    Collection<DataSource> list(Integer idCompany);

    DataSource get(Integer idDataSource);

    Integer register(DataSource dataSource);

    Integer update(Integer idDataSource, DataSource dataSource);

    Integer delete(Integer idDataSource);
}
