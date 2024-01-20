package com.deepdive;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class EmployeePOJO {
    @Test
    public void getEmployee(){

        Response employees=given().get("http://localhost:3000/posts");
        System.out.println(employees.statusCode());
        employees.prettyPrint();


    }
    @Test
    public void addEmployee(){
        String payload="{\r\n\"id\":2,\r\n\"first_name\":\"captain\",\r\n\"last_name\":\"Miller\",\r\n\"email\":\"miller@codingthesmartway.com\"\r\n}";
        Response resp=given().body(payload).post("http://localhost:3000/posts");
        resp.prettyPrint();
    }
    @Test
    public void deleteEmployee(){
        Response resp=given().delete("http://localhost:3000/posts/4");
        System.out.println(resp.statusCode());
    }


}
