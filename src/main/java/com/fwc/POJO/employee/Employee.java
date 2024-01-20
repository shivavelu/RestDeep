package com.fwc.POJO.employee;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder(setterPrefix = "set")
@ToString
@AllArgsConstructor
//@Data
public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private List<Integer> salary;
    //public Employee(){}

}
