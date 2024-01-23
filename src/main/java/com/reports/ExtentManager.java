package com.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    private static ThreadLocal<ExtentTest> exTest= new ThreadLocal<>();
    private ExtentManager(){

    }
    public static ExtentTest getTest(){
        return exTest.get();
    }
    public static void setExtent(ExtentTest test){
        exTest.set(test);
    }
}
