package com.restAssured.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.restAssured.core.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

@Feature("Movies API")
public class MovieTest extends BaseTest {
    @Story("Show the movies registered")
    @Issue("http://google.com")
    @Test(description = "descrição do teste")
    @Description("Should be able to find all available videos")
    public void validateIdReturned() {
        given().
                basePath("76341/videos").
                when().
                get().
                then()
                .statusCode(200)

                // It has'not to be in the same order
                .body("results.id", hasItems("5bcd2702c3a3682863018582", "5bcd26f9925141612a0157ce",
                        "5bcd26ef9251416126015b7d", "5bcd26e39251416131016aba"))

                // It has to be in the same order
                .body("results.id", contains("5bcd2702c3a3682863018582", "5bcd26f9925141612a0157ce","5bcd26ef9251416126015b7d", "5bcd26e39251416131016aba"),
                        "results.id", everyItem(startsWith("5bcd")))
        ;
    }
    @Story("Show the movies registered")
    @TmsLink("www.globo.com")
    @Test
    @Description("Should be able to check the amount of videos")
    @Step
    public void validateQuantityReturned() {
        given().
                basePath("76341/videos").
                when().
                get().
                then()
                .statusCode(200)
                .log().all()
                .body("results", is(not(emptyArray())),
                        "results", hasSize(4),
                        "results[0]", hasKey("id"),
                        "results[0]", hasEntry("id", "5bcd2702c3a3682863018582"),
                        "results[0]", hasEntry("id", "5bcd2702c3a3682863018582"))
        ;
    }
}
