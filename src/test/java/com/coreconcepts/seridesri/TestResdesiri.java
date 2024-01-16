package com.coreconcepts.seridesri;

import com.api.builderlambok.BlockFuster;
import com.api.builderlambok.Employee;
import com.api.builderlambok.Food;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class TestResdesiri {
    @Test //Response validation by desielaization by restassured as() and jsonpath()
    public void builder6(){
        Employee ee= Employee.builder().id(131).first_name("poonam").last_name("bajwa")
                .email("bb@tollywood.com").jobs(Arrays.asList("Actor","SocialActivist"))
                .food(new Food("dosa","meals", Arrays.asList("idly","milk")))
                .blockFusters(Arrays.asList(new BlockFuster(20,5,200), new BlockFuster(15,10,2003))).build();
        Response resp= given()
                .log()
                .all()
                .body(ee)
                .post("http://localhost:3000/posts");
        resp.then().statusCode(201);
        resp.prettyPrint();
        Employee emp = resp.as(Employee.class); // Mapping json response to respective class object
        emp.getFood().getDinner().stream().forEach(System.out::println);
        System.out.println(emp.getJobs().get(1));
        System.out.println(resp.jsonPath().getList("jobs"));
        System.out.println(resp.jsonPath().getInt("blockFusters[0].tamil"));
    }

}
