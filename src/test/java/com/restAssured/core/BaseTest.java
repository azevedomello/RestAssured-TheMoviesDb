package com.restAssured.core;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest implements Constants{

    @BeforeClass
    public void setup(){
        baseURI = BASE_URL;
       // port = 8080;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(CONTENT_TYPE);
        reqBuilder.addParam("api_key",getApiKey());
        requestSpecification = reqBuilder.build();

        ResponseSpecBuilder respBuilder = new ResponseSpecBuilder();
        respBuilder.expectContentType(CONTENT_TYPE);
        responseSpecification = respBuilder.build();

        //enableLoggingOfRequestAndResponseIfValidationFails();
    }
   public static String getApiKey(){
        String apiKey = "aa6850592ae68e97a81772c17865e1db";
        return apiKey;
   }

}
