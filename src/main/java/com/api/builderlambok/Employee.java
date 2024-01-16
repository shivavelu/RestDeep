package com.api.builderlambok;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@JsonInclude(value= JsonInclude.Include.NON_EMPTY) // this ignore the attribute if the value is null & empty and Inclue.NON_NULL ignore only NULL value
// NON_EMPTY ignore both null and empty attribute
@Builder // should have builder annotation only as builder() travel from here

/*
Jackson Properties
//@JsonIgnoreProperties(value = {"first_name"})
@JsonPropertyOrder(alphabetic = true) --> order payload based on alphabetic order
@JsonPropertyOrder(value={"first_name","jobs"}) --> order payload on order mentioned here
@JsonIgnoreProperties(value = {"first_name"}) --> Ignore multiple property for payload at class
@JsonIgnore --> Ignore property for payload at variable level in class
 */
public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private List<String> jobs;
    private Food food;
    //@JsonIgnore you can ignore this properperty during payload passing
    private List<BlockFuster> blockFusters;

    public Employee() {
    }
}
