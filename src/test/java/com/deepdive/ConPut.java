package com.deepdive;

import com.api.lombk.Actor;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class ConPut {

    @Test
    public void addActor(ITestContext context){
        Actor aa= Actor.builder().id(153).first_name("").second_name("kumar").email("aj@kolly.com").build();
        Response resp=given()
                      .log()
                      .all()
                      .body(aa)
                      .post("http://localhost:3000/posts");
        resp.then().statusCode(201);
        resp.prettyPrint();
       context.setAttribute("id",151);

    }

    @Test(dependsOnMethods = {"addActor"})
    public void putActor(ITestContext context){
        Actor aa= Actor.builder().id((int)context.getAttribute("id")).first_name("Rajini").second_name("kanth").email("rajinikanth@kollywood.com").build();
        Response resp=given()
                .pathParam("id",context.getAttribute("id"))
                .log()
                .all()
                .body(aa)
                .put("http://localhost:3000/posts/{id}");
        resp.prettyPrint();

    }
   // @Test
    public void putActor1(){
        Actor aa= Actor.builder().id(151).first_name("Rajini").second_name("kanth").email("rajinikanth@kollywood.com").build();
        Response resp=given()
                .pathParam("id",151)
                .log()
                .all()
                .body(aa)
                .put("http://localhost:3000/posts/{id}");
        resp.prettyPrint();

    }
}
