package com.deepdive;

import com.api.pojo.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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

    /*
    Using map and list from java
    {} -> Map
    [] -> List
     Without databinding library object will not able covert to json (serialization), in this case use jackson databiding
     That will be added to class path and during run time handled automatically
     */
    @Test
    public void objPost(){

        Map<String, Object> pl= new LinkedHashMap<>();
        pl.put("id",25);
        pl.put("first_name","Tabu");
        pl.put("last_name","agarwal");
        pl.put("email","tabuagr@bollywood.com");
        Response resp= given()
                .log()
                .all()
                .body(pl)
                .post("http://localhost:3000/posts");
        resp.then().statusCode(201);
        resp.prettyPrint();

    }

    /*
    Disadvantages of this object pl
    -- Verbose
    -- When payload increases tend to make mistake and handling larger and complex is difficult
    -- generic type needs to be mentioned ( like object type)

     */

    @Test
    public void objPostwithComplexPL(){
        /*
        {
  "id": "4",
  "first_name": "Rashi",
  "last_name": "Kanna",
  "email": "rkanna@codingthesmartway.com",
  "jobs":["actor","model"],
   "diet":{
      "breakfast":"Idly",
      "lunch":"Rice",
      "dinner":["chapati","Milk']

   }
   }
         */

        Map<String,Object> pl= new LinkedHashMap<>();
        pl.put("id",29);
        pl.put("first_name","preeti");
        pl.put("last_name","zinda");
        pl.put("email","preetiz@kollywood.com");

        List<String> jobs= new ArrayList<>();
        jobs.add("actor");
        jobs.add("model");
        pl.put("jobs",jobs);
        Map<String, Object> diet= new LinkedHashMap<>();
        diet.put("breakfast","idly");
        diet.put("lunch","rice");
        List<String> dinner= new ArrayList<>();
        dinner.add("chappati");
        dinner.add("milk");
        diet.put("dinner",dinner);
        pl.put("diet",diet);

        Response resp= given()
                       .log()
                       .all()
                       .body(pl)
                       .post("http://localhost:3000/posts");
        resp.then().statusCode(201);
        resp.prettyPrint();
    }

     /*

   Jackson lib --> serialize the payload
   json --> build payload in simple rather using collects map -->{} and List -->[], besides it has built method to set the payload
   programitcally based on the condition
   {} --> JsonObject
   [] --> JsonArray
   Generics will be handled by Json lib.

     */
    @Test
    public void objjsonPost(){

        JSONObject pl= new JSONObject();
        pl.put("id",30);
        pl.put("first_name","Trisha");
        pl.put("last_name","Krishan");
        pl.put("email","trishak@tollywood.com");

        JSONArray jobs= new JSONArray();
        jobs.put("actor");
        jobs.put("model");
        pl.put("jobs",jobs);

        JSONObject diet= new JSONObject();
        diet.put("breakfast","dosa");
        diet.put("lunch", "meals");
        JSONArray dinner= new JSONArray();
        dinner.put("dryfruit");
        dinner.put("milk");
        diet.put("dinner",dinner);

        pl.put("diet",diet);

        Response resp= given()
                .header("Content-Type","application/json").header("Accept","application/json")
                .log()
                .all()
                .body(pl.toString()) // pl.toMap() ->(Jackson), pl.toString()-> (json)without convert to toString it will pass empty value either needs to covert toString() using json and convert to toMap() using jackson
                .post("http://localhost:3000/posts");

        resp.then().statusCode(201);
        resp.prettyPrint();

    }

    @Test
    public void pojoPost(){

        //Diet diet= new Diet("vegsalad","ricedall",Arrays.asList("chappati","subji")); // dinner object can be replaced with last argument Arrays.aslist
        List<String> dinner= new ArrayList<>();
        dinner.add("chapati");
        dinner.add("subji");
        Diet diet= new Diet("vegsalad","ricedall",dinner);
        //UserPojo user= new UserPojo(38, "sada","jeyam", "sada@kollywood.com", Arrays.asList("actress","enterprenur"),diet); // jobs object can replaced with last argument
        List<String> jobs= new ArrayList<>();
        jobs.add("actress");
        jobs.add("enterprenur");
        UserPojo user= new UserPojo(38, "sada","jeyam", "sada@kollywood.com",jobs,diet);

        Response  resp= given()
                        .log()
                        .all()
                        .body(user)
                        .post("http://localhost:3000/posts");

        resp.then().statusCode(201);
        resp.prettyPrint();
    }

    @Test
    public void pojoPost2(){

        Hits h1= new Hits(20,7,"2003");
        Hits h2= new Hits(30, 10, "2005");
        List<Hits> hits= new ArrayList<>();
        hits.add(h1);
        hits.add(h2);
        Diet diet= new Diet("vegsalad","ricedall",Arrays.asList("chappati","subji")); // dinner object can be replaced with last argument Arrays.aslist
        UserhitsPojo user= new UserhitsPojo(50, "sada","jeyam", "sada@kollywood.com", Arrays.asList("actress","enterprenur"),diet,
               hits); // jobs object can replaced with last argument
        Response  resp= given()
                .log()
                .all()
                .body(user)
                .post("http://localhost:3000/posts");

        resp.then().statusCode(201);
        resp.prettyPrint();
    }

}
