package br.com.spring.jersey.resources;

import br.com.spring.jersey.dto.Company;
import br.com.spring.jersey.services.CompanyService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("companies")
@Controller
public class CompanyResource {

    private final CompanyService companyService;
    private static final Gson GSON = new Gson();

    @Autowired
    public CompanyResource(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GET
    @Path("/{idCompany}")
    public Response get(@PathParam("idCompany") Integer idCompany) {
        Company company = this.companyService.get(idCompany);
        return Response.ok(GSON.toJson(company))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @PUT
    @Path("/{idCompany}")
    public Response update(@PathParam("idCompany") Integer idCompany, String companyJson) {
        Company company = GSON.fromJson(companyJson, Company.class);
        this.companyService.update(idCompany, company);
        return Response.ok()
                .build();
    }
}
