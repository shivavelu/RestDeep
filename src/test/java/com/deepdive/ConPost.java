package com.deepdive;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

public class ConPost {

    // 1. Passing json body as String, it is not recommended, code readbility, maintenance, customization not easy
    //easy to use mean copy paste --> can be used to quickly check the behaviour
    // not recommended for longer json or dynamic json
    @Test
    public void StringPost(){

        Response resp=given()
                .header("Content-Type","application/json")
                .body("{\r\n\"id\":4,\r\n\"first_name\":\"Namitha\",\r\n\"last_name\":\"das\",\r\n\"email\":\"nmdas@codingthesmartway.com\"\r\n}")
                .log()
                .all()
                .post("http://localhost:3000/posts/");
        System.out.println(resp.statusCode());
        resp.then().statusCode(201);
        resp.prettyPrint();
    }

    /*
      pass payload from the external file
      1. You cannot get the request log details as it not allowed read the file content on the console
      2. Use file only for static data


     */
    @Test
    public void filePost(){
        Response resp=given().header("Content-Type", ContentType.JSON)
                      .body(new File("./src/test/resources/payloaduser.json"))
                      .log()
                      .all()
                      .post("http://localhost:3000/posts/");
        resp.then().statusCode(201);
        resp.prettyPrint();
    }

    /*
    // read req body from an external file and convert to string
    It prints the log in console
    Change the paramter request payload after converting to string by replace methods
   */
    @Test
    public void fileStringPost() throws IOException {

        byte[] pl = Files.readAllBytes(Paths.get("./src/test/resources/payloaduser.json"));
        String s= new String(pl);
        Response  resp= given().header("Content-Type",ContentType.JSON)
                .log()
                .all()
                .body(s)
                .post("http://localhost:3000/posts");
        resp.then().statusCode(201);
        resp.prettyPrint();
    }
}
