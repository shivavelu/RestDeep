package com.api.builderlambok;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
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
