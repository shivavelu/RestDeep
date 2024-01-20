package com.api.lombk;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Actor {
    private int id;
    private String first_name;
    private String second_name;
    private String email;
}
