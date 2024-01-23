package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.Getter;
import lombok.Setter;

public final class ExtentReport {

   private static ExtentReports extRep;

   private static ExtentTest test;
    private ExtentReport(){

    }


    public static void initReports(){
        extRep= new ExtentReports();
        ExtentSparkReporter spark= new ExtentSparkReporter("index.html");
        extRep.attachReporter(spark);
    }

    public static void createTest(String name){
        test=extRep.createTest(name);
        ExtentManager.setExtent(test);

    }

    public static void tearDownReports(){
        extRep.flush();
    }
}
