package com.coreconcepts.seridesri;

import com.api.builderlambok.BlockFuster;
import com.api.builderlambok.Employee;
import com.api.builderlambok.Food;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.base.BaseTest;
import com.fwc.specbuilder.ApiBuilder;
import com.reports.ExtentManager;
import com.reports.ExtentReport;
import com.reports.Extentlogger;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.ExceptionLogger;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class TestResdesiri extends BaseTest {
    @Test //Response validation by desielaization by restassured as() and jsonpath()
    public void builder6(){
        Employee ee= Employee.builder().id(131).first_name("poonam").last_name("bajwa")
                .email("bb@tollywood.com").jobs(Arrays.asList("Actor","SocialActivist"))
                .food(new Food("dosa","meals", Arrays.asList("idly","milk")))
                .blockFusters(Arrays.asList(new BlockFuster(20,5,200), new BlockFuster(15,10,2003))).build();
      /*  Response resp= given()
                .log()
                .all()
                .body(ee)
                .post("http://localhost:3000/posts");*/

        // There is no stright forward way to print request to extent report, below is approach to implement the same
        RequestSpecification requestSpecification= ApiBuilder.reqSpecBuilderPost().body(ee);
        Extentlogger.logRequest(requestSpecification);
        Response resp=requestSpecification.post("/posts");
        resp.then().statusCode(201);
        resp.prettyPrint();
        Extentlogger.logReponse(resp.prettyPrint());
        Employee emp = resp.as(Employee.class); // Mapping json response to respective class object
        emp.getFood().getDinner().stream().forEach(System.out::println);
        System.out.println(emp.getJobs().get(1));
        System.out.println(resp.jsonPath().getList("jobs"));
        System.out.println(resp.jsonPath().getInt("blockFusters[0].tamil"));
    }

   @Test //Response validation by desielaization by restassured as() and jsonpath()
    public void builder7(){
        Employee ee= Employee.builder().id(132).first_name("poonam").last_name("bajwa")
                .email("bb@tollywood.com").jobs(Arrays.asList("Actor","SocialActivist"))
                .food(new Food("dosa","meals", Arrays.asList("idly","milk")))
                .blockFusters(Arrays.asList(new BlockFuster(20,5,200), new BlockFuster(15,10,2003))).build();
        Response resp= given()
                .log()
                .all()
                .body(ee)
                .post("http://localhost:3000/posts");
        Extentlogger.logReponse(resp.prettyPrint());
        resp.then().statusCode(201);
       Extentlogger.logReponse(resp.prettyPrint());
        Employee emp = resp.as(Employee.class); // Mapping json response to respective class object


    }

}
