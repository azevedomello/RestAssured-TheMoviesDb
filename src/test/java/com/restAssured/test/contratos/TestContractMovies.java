package com.restAssured.test.contratos;

import com.restAssured.core.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

@Feature("TestContract APIs")
public class TestContractMovies extends BaseTest{
        @Test(description = "Should be able to validate of GetMovie contract")
        @Description("validate of GetMovie contract")
        public void validateIdReturned() {
            given().
                    basePath("76341/videos").
                    when().
                    get().
                    then()
                    .statusCode(200)
                    .body(matchesJsonSchemaInClasspath("ContractGetMovies"))
            ;
        }




}
