package org.acme.controller;

import org.acme.entity.Company;
import org.acme.service.CompanyService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/company")
public class CompanyController {

    @Inject
    CompanyService companyService;

    @POST
    @Transactional
    public Response saveCompany(Company company) {

        Optional<Company> savedCompany = companyService.saveCompany(company);

        if (savedCompany.isPresent()) {
            return Response.ok(savedCompany.get()).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GET
    public Response findAllCompanies() {
        Optional<List<Company>> companies = companyService.getCompanies();
        if (companies.isPresent()) {
            return Response.ok(companies).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
