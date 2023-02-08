package org.acme.service;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.entity.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@QuarkusTest
public class CompanyServiceTest {

    @Inject
    CompanyService service;
    @Test
    @TestTransaction
    public void testGetCompanies(){

        Company company = new Company();
        company.setName("Test Company");
        company.setAddress("Street ABC");
        company.setPhone("222333444");
        company.setRegistry("111222333");

        service.saveCompany(company);

        List<Company> companies = new ArrayList<>();
        companies.add(company);

        Optional<List<Company>> expected = Optional.of(companies);
        Optional<List<Company>> actual = service.getCompanies();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @TestTransaction
    public void testSaveCompany(){

        Company company = new Company();
        company.setName("Test Company");
        company.setAddress("Street ABC");
        company.setPhone("222333444");
        company.setRegistry("111222333");

        Assertions.assertEquals(Optional.of(company), service.saveCompany(company));
    }

    @Test
    @TestTransaction
    public void testErrorSaveCompany(){
        Assertions.assertEquals(Optional.empty(), service.saveCompany(null));
    }



}
