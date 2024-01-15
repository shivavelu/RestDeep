package com.deepdive;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ConDelete {

    @Test
    public void delUser(){

        Response resp= given()
                       .log()
                       .all()
                       .delete("http://localhost:3000/posts/126");
        System.out.println(resp.statusCode());
    }
}
