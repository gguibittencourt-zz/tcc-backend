package br.com.spring.jersey.services;

import br.com.spring.jersey.dto.Company;

public interface CompanyService {

    Company get(Integer idCompany);

    Integer register(Company company);

    Integer update(Integer idCompany, Company newCompany);
}
