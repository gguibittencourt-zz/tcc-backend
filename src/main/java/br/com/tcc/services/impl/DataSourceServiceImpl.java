package br.com.tcc.services.impl;

import br.com.tcc.dao.DataSourceDAO;
import br.com.tcc.dto.DataSource;
import br.com.tcc.services.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DataSourceServiceImpl implements DataSourceService {

    private final DataSourceDAO dataSourceDAO;

    @Autowired
    public DataSourceServiceImpl(DataSourceDAO dataSourceDAO) {
        this.dataSourceDAO = dataSourceDAO;
    }

    @Override
    public Collection<DataSource> list(Integer idCompany) {
        return this.dataSourceDAO.list(idCompany);
    }

    @Override
    public DataSource get(Integer idDataSource) {
        return this.dataSourceDAO.get(idDataSource);
    }

    @Override
    public Integer register(DataSource dataSource) {
        return this.dataSourceDAO.register(dataSource);
    }

    @Override
    public Integer update(Integer idDataSource, DataSource dataSource) {
        return this.dataSourceDAO.update(idDataSource, dataSource);
    }

    @Override
    public Integer delete(Integer idDataSource) {
        return this.dataSourceDAO.delete(idDataSource);
    }

}
