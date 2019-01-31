package br.com.tcc.dao;

import br.com.tcc.dto.Company;

public interface CompanyDAO {

    Company get(Integer idCompany);

    Integer register(Company company);

    int update(Integer idCompany, Company company);
}
