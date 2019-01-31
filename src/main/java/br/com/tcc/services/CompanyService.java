package br.com.tcc.services;

import br.com.tcc.dto.Company;

public interface CompanyService {

    Company get(Integer idCompany);

    Integer register(Company company);

    Integer update(Integer idCompany, Company newCompany);
}
