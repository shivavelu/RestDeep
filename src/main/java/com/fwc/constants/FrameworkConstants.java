package com.fwc.constants;

import lombok.Getter;

// If it is class you can have @Getter and @Setter at class level
public class FrameworkConstants {

    // If it is non static lombok getter and setter should at variable level
    private static @Getter final String REQ_INPUT_PATH= System.getProperty("user.dir")+"/src/test/resources/request/";

}
