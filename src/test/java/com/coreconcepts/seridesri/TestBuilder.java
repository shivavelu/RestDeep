package com.coreconcepts.seridesri;

import com.api.builderlambok.BlockFuster;
import com.api.builderlambok.Employee;
import com.api.builderlambok.Food;
import com.api.lombk.Actor;
import com.api.builerpat.Student;
import com.api.builerpat.StudentBuilder;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.*;

public class TestBuilder {

    /*
    Why we go for Builder Design Pattern ? to construct the payload
    // To give Immutability to the student class
    // 1. No of parameters increases the readability decrease the complex and confusion steps
    // 2. In case if want to build a payload with option field (leave option fiedl empty) build desing pattern solves this
    // Normal pojo class very difficult to create multiple constructors
    // Builder desing pattern can be implemented in two ways
         1. External Builder - builder class implement in normal class externally from student class
         2. Internal - static inner class with the student class
     */
    @Test // External implementation call
    public void builder1(){
        // with all the fields
        Student us1 = new StudentBuilder().builder().setId(100).setFirst_name("virat").setSecond_name("kholi").setEmail("viratkohali@bcci.com").build();
        System.out.println(us1);
        // with option fields, firstname not set
        Student us2 = StudentBuilder.builder().setId(100).setSecond_name("sharma").setEmail("rohitsharma@bcci.com").build();
        System.out.println(us2);

    }

    @Test //Internal Implementation call
    public void builder2(){
        Student usi3 = Student.builder().setId(101).setFirst_name("suresh").setSecond_name("raina").build();
        System.out.println(usi3);
    }

    @Test //Lombok Implementation call
    public void builder3(){
        Actor ss = Actor.builder().id(108).first_name("Banu").second_name("priya").email("NA").build();
        Response resp= given()
                       .log()
                       .all()
                       .body(ss)
                       .post("http://localhost:3000/posts");
        resp.then().statusCode(201);
        resp.prettyPrint();

    }
    @Test //Lombok Implementation call complex pojo
    public void builder4(){
        Employee ee= Employee.builder().id(126).first_name("Ranjitha").last_name("menon")
                .email("ranjitha@kollywood.com").jobs(Arrays.asList("Actor","SocialActivist"))
                .food(new Food("dosa","meals", Arrays.asList("idly","milk")))
                .blockFusters(Arrays.asList(new BlockFuster(20,5,200), new BlockFuster(15,10,2003))).build();
        Response resp= given()
                .log()
                .all()
                .body(ee)
                .post("http://localhost:3000/posts");
        resp.then().statusCode(201);
        resp.prettyPrint();

    }
    @Test //Lombok Implementation call complex pojo
    public void builder5(){
        Employee ee= Employee.builder().id(128).first_name("priyanka").last_name("chopra")
                .email("prinyanka@kollywood.com").jobs(Arrays.asList("Actor","SocialActivist"))
                .food(new Food("dosa","meals", Arrays.asList("idly","milk")))
                .blockFusters(Arrays.asList(new BlockFuster(20,5,200), new BlockFuster(15,10,2003))).build();
        Response resp= given()
                .log()
                .all()
                .body(ee)
                .post("http://localhost:3000/posts");
        resp.then().statusCode(201);
        resp.prettyPrint();

    }
    @Test //Jackson annotation validation
    public void builder6(){
        Employee ee= Employee.builder().id(132).first_name("priyanka").last_name(null)
                .email(null).jobs(Arrays.asList("Actor","SocialActivist"))
                .food(new Food("dosa","meals", Arrays.asList("idly","milk")))
                .blockFusters(Arrays.asList(new BlockFuster(20,5,200), new BlockFuster(15,10,2003))).build();
        Response resp= given()
                .log()
                .all()
                .body(ee)
                .post("http://localhost:3000/posts");
        resp.then().statusCode(201);
        resp.prettyPrint();
    }
}
