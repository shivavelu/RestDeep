package com.fwc.constants;

import lombok.Getter;

@Getter
public class FCSingleton {

    private FCSingleton(){}
    private static FCSingleton FCInstance=null;
    public static FCSingleton getInstance(){
        if(FCInstance==null){
            FCInstance= new FCSingleton();
        }
        return FCInstance;
    }
    // If want make this method thread safe, make this method synchronized
    public static synchronized FCSingleton getSInstance(){
        if(FCInstance==null){
            FCInstance= new FCSingleton();
        }
        return FCInstance;
    }
    private final String requestInputPath=System.getProperty("user.dir")+"/src/test/resources/request/";
}
