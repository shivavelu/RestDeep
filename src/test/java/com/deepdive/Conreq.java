package com.deepdive;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Conreq {

    /*
    static imports --> as we call the given() method without calling its object/class name, since it is
    static method,it can be called by calss name, as to readability and clean code import the packeage
    by static import hence those static methods directly called

    Rest Assured supports BDD way and non BDD way

    given().when().then() -> Sugarcoated methods --> readability

     */


    @Test
    public void getEmployee(){

        Response employees=given().when().get("http://localhost:3000/posts");
        employees.then().statusCode(200);
        System.out.println(employees.statusCode());
        employees.getHeaders().asList().stream().forEach(header->{
            System.out.println(header.getName()+"="+header.getValue());
        });
        // or
        employees.getHeaders().asList().stream().forEach(System.out::println);
        System.out.println(employees.getTime());
        employees.prettyPrint();


    }

}
