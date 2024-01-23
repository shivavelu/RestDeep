package com.dptest;

import com.api.builderlambok.Employee;
import com.fwc.specbuilder.ApiBuilder;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class DP2 {

    @Test(dataProvider = "userGet")
    public void dpValiatoin(Integer id, String fname) {
        Response resp = ApiBuilder.reqSpecBuilderGet().pathParam("id",id)
                        .get("/posts/{id}");

       resp.prettyPrint();
        assertThat(resp.statusCode()).isEqualTo(200);
        assertThat(resp.jsonPath().getString("first_name")).isEqualTo(fname);
    }


    @DataProvider
    public Object[][] userGet(){

        return new Object[][]{
                {155,"sherya"},{128,"priyanka"}
        };
    }

    @Test
    public void userget() {
        Response resp = ApiBuilder.reqSpecBuilderGet()
                .get("/posts/155");
        Assertions.assertThat(resp.as(Employee.class).getFirst_name()).isEqualTo("sada");
        resp.prettyPrint();

        assertThat(resp.statusCode()).isEqualTo(200);
        assertThat(resp.jsonPath().getString("first_name")).isEqualTo("sada");
    }
}
