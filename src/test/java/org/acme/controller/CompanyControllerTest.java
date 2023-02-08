package org.acme.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.acme.entity.Company;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@QuarkusTest
public class CompanyControllerTest {

    @Test
    public void testSaveCompanyEndPoint() throws Exception {

        Company company = new Company();
        company.setName("Test Company");
        company.setAddress("Street ABC");
        company.setPhone("222333555");
        company.setRegistry("222588888");

        RestAssured
                .given()
                .contentType("application/json")
                .body(company)
                .when()
                .post("/company")
                .then()
                .statusCode(200)
                .body("name", equalTo("Test Company"))
                .body("address", equalTo("Street ABC"))
                .body("phone", equalTo("222333555"))
                .body("registry", equalTo("222588888"));

    }

    @Test
    public void testFindAllCompaniesEndPoint() throws Exception {
        RestAssured
                .when()
                .get("/company")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(0));
    }

}
