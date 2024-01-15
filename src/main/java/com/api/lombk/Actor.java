package com.api.lombk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class Actor {
    private int id;
    private String first_name;
    private String second_name;
    private String email;
}
