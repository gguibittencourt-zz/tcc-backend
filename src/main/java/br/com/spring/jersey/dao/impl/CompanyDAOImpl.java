package br.com.spring.jersey.dao.impl;

import br.com.spring.jersey.dao.CompanyDAO;
import br.com.spring.jersey.dao.metadata.Tables;
import br.com.spring.jersey.dto.Company;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

    private final DSLContext dslContext;

    @Autowired
    public CompanyDAOImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public Company get(Integer idCompany) {
        return this.dslContext
                .selectFrom(Tables.COMPANY)
                .where(Tables.COMPANY.ID_COMPANY.eq(idCompany))
                .fetchOneInto(Company.class);
    }

    @Override
    public Integer register(Company company) {
        return this.dslContext
                .insertInto(Tables.COMPANY)
                .set(Tables.COMPANY.NAME, company.getName())
                .set(Tables.COMPANY.CONTRIBUTORS, company.getContributors())
                .set(Tables.COMPANY.PROJECTS, company.getProjects())
                .set(Tables.COMPANY.OCCUPATION_AREA, company.getOccupationArea())
                .returning(Tables.COMPANY.ID_COMPANY)
                .fetchOne().getIdCompany();
    }

    @Override
    public int update(Integer idCompany, Company company) {
        return this.dslContext
                .update(Tables.COMPANY)
                .set(Tables.COMPANY.NAME, company.getName())
                .set(Tables.COMPANY.CONTRIBUTORS, company.getContributors())
                .set(Tables.COMPANY.PROJECTS, company.getProjects())
                .set(Tables.COMPANY.OCCUPATION_AREA, company.getOccupationArea())
                .where(Tables.COMPANY.ID_COMPANY.eq(idCompany))
                .execute();
    }
}
