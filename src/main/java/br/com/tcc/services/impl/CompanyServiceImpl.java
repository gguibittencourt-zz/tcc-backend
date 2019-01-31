package br.com.tcc.services.impl;

import br.com.tcc.dao.CompanyDAO;
import br.com.tcc.dto.Company;
import br.com.tcc.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDAO companyDAO;

    @Autowired
    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public Company get(Integer idCompany) {
        return this.companyDAO.get(idCompany);
    }

    @Override
    public Integer register(Company company) {
        return this.companyDAO.register(company);
    }

    @Override
    public Integer update(Integer idCompany, Company newCompany) {
        return this.companyDAO.update(idCompany, newCompany);
    }

}
