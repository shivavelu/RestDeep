package com.oauth2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;

public class Testoauth {


    String clientId="ed0fbd8cd298a4a1b3d822637a936ce4";
    String sceretId= "c5e3fbcaced205fee5a4e4d36af62abcee1c40a30cb3fca7224ad638199d6bca";

    String authorizatioCode="Basic c2l2YWF3czg6VGFtYmFyYW0hMQ==";

    @Test
    public void getAccesstoken(){

        RequestSpecification requestSpecification =RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");

        Response response = requestSpecification.param("client_id", clientId)
                .param("code",authorizatioCode)
                .param("client_secret", sceretId)
                .param("grant_type", "authorization_code")
                .post("http://localhost:8080/oauth/token");
        response.prettyPrint();

    }

    @Test
    public void basicTest(){

       Response resp=given().header("Authorization",authorizatioCode)
                .get("http://localhost:8080/rest/api/2/mypermissions");
       resp.prettyPrint();
    }
}
