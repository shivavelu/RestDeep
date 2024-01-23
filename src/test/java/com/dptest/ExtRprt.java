package com.dptest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

public class ExtRprt {

    @Test
    public void extrepDemo(){
        //Before Suite
        ExtentReports extRep= new ExtentReports();
        ExtentSparkReporter spark= new ExtentSparkReporter("index.html");
        extRep.attachReporter(spark);


        //Tests
        ExtentTest test1= extRep.createTest("Sample Test");
        test1.log(Status.PASS,"Test event logged, Passed");

        ExtentTest test2= extRep.createTest("Login Test");
        test2.log(Status.PASS,"Test event logged, Passed");

        //After suite
        extRep.flush();
    }
}
