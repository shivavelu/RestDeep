package com.coreconcepts.seridesri;


import com.api.builderlambok.BlockFuster;
import com.api.builderlambok.Employee;
import com.api.builderlambok.Food;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.*;

public class TestResdeseobjtMapper {

    @Test //validate response by desriazation using ObjectMapper
    public void objMapperDese(){

        Employee ee = Employee.builder().id(155)
                .first_name("sherya")
                .last_name("sharan")
                .email("shreya@kollywood.com")
                .jobs(Arrays.asList("actress", "model"))
                .food(new Food("Noodles", "chappati", Arrays.asList("dos", "dryfruit")))
                .blockFusters(Arrays.asList(new BlockFuster(7, 15, 2004), new BlockFuster(5, 10, 2005)))
                .build();
        Response resp= given()
                       .log()
                       .all()
                       .body(ee)
                       .post("http://localhost:3000/posts");

        ObjectMapper objMap = new ObjectMapper();
        Employee emp=null;
        try {
            emp = objMap.readValue(resp.asString(), Employee.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        emp.getBlockFusters().stream().forEach(System.out::println);
        emp.getJobs().stream().forEach(System.out::println);
        System.out.println(emp.getFood().getBreakfast());
        System.out.println(emp.getId());
        System.out.println(emp.getFirst_name());
        System.out.println(emp.getLast_name());
        Assert.assertEquals(emp.getId(),155);
        System.out.println(emp.getEmail());
        resp.prettyPrint();

    }
}
