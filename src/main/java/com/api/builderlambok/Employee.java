package com.api.builderlambok;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@JsonInclude(value= JsonInclude.Include.NON_EMPTY) // this ignore the attribute if the value is null & empty and Inclue.NON_NULL ignore only NULL value
// NON_EMPTY ignore both null and empty attribute
@Builder // should have builder annotation only as builder() travel from here
public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private List<String> jobs;
    private Food food;
    private List<BlockFuster> blockFusters;

}
