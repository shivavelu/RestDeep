package com.validationassertj;

import com.fwc.POJO.employee.Employee;
import com.fwc.specbuilder.ApiBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.Arrays;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.*;

public class Testaj1 {

    @Test
    public void basicValidation() {
        Response resp = given()
                .get("http://localhost:3000/comments");

        assertThat(resp.statusCode()).isEqualTo(200);
        assertThat(resp.jsonPath().getList("$").size()).as("validtion size").isEqualTo(2);
    }
    @Test
    public void basicValidation2() {
        Response resp = given()
                .get("http://localhost:3000/posts/155");

        assertThat(resp.statusCode()).isEqualTo(200);
        assertThat(resp.jsonPath().getString("first_name")).isEqualTo("sherya");
    }

    @Test
    public void basicValidation3(){

        Employee se = Employee.builder().setId(500).setFirst_name("Sachin").setLast_name("tendulkar")
                .setEmail("sachin@cricket.com").setSalary(Arrays.asList(100000, 2000, 500)).build();
             Response resp= ApiBuilder.reqSpecBuilderGet().body(se).post("/posts");
             resp.prettyPrint();
             Employee eds=resp.as(Employee.class);
             assertThat(resp.jsonPath().getString("first_name")).isEqualTo("Sachin");
             assertThat(eds.getLast_name()).isEqualTo("tendulkar");
             assertThat(resp.getTime()).isLessThan(600).as("Time taken",resp.getTime());
    }
}
