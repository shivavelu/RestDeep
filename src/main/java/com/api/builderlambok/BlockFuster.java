package com.api.builderlambok;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
//@Builder --> Always good to have builder annotation in main class ie., Employee
public class BlockFuster {

    private int tamil;
    private int telugu;
    private int year;


}
