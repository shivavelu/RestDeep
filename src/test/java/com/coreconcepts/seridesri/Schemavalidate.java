package com.coreconcepts.seridesri;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;

import static io.restassured.RestAssured.*;

public class Schemavalidate {


    @Test
    public void schmeaValidation(){

                Response resp  = given()
                       .get("http://localhost:3000/posts/155");

                resp.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("useraddschema.json"));
        //resp.then().body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir"+"/src/test/resources/schemas/userschema.json"))));
    }
}
