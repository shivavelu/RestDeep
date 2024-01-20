package com.api.builderlambok;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@ToString
//@Builder It is alwasy good to have Builder annotation in parent class to avoid
// choosing the builder, it has to be always from main class builder

public class Food {
    private String breakfast;
    private String lunch;
    private List<String> dinner;

    public Food() {
    }
}
