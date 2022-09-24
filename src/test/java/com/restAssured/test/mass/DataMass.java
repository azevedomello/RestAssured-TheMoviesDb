package com.restAssured.test.mass;
import org.testng.annotations.DataProvider;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

public class DataMass {

    @DataProvider(name = "dtCodeFilms")
    public Object[][] getTitlesCodeFilms(){
        return new Object[][]{
                {"852448"},
                {"862551"}
        };
    }
}
