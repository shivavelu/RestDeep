package com.coreconcepts.seridesri;

import com.api.builderlambok.Employee;
import com.api.lombk.CountryCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.*;

public class TestResAry {

    @Test
    public void respAryTest() throws JsonProcessingException {

        Response resp= given().get("https://restful-booker.herokuapp.com/booking");
        //resp.prettyPrint();
        /* Object Mapper using rest assured*/
        CountryCode[] code = resp.as(CountryCode[].class);
        Arrays.stream(code).forEach(System.out::println);

        /* Object Mapper using jackson*/
    /*   ObjectMapper ob= new ObjectMapper();
       CountryCode[] cc = ob.readValue(resp.asString(), CountryCode[].class);
       Arrays.stream(cc).forEach(System.out::println);*/

    }
}
