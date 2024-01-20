package com.fwc.constants;

import lombok.Getter;

// If it is class you can have @Getter and @Setter at class level
public class FrameworkConstants {
    private static @Getter final String CWD=System.getProperty("user.dir");
    // If it is non static lombok getter and setter should at variable level
    private static @Getter final String REQ_INPUT_PATH= CWD+"/src/test/resources/request/";
    private static @Getter final String PROPERTY_FILEPATH=CWD+"/src/main/resources/configproperty/Config.properties";

}
