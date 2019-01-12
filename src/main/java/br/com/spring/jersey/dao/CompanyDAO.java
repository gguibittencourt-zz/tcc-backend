package br.com.spring.jersey.dao;

import br.com.spring.jersey.dto.Company;

public interface CompanyDAO {

    Company get(Integer idCompany);

    Integer register(Company company);

    int update(Integer idCompany, Company company);
}
