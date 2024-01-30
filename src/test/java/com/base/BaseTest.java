package com.base;

import com.aventstack.extentreports.ExtentTest;
import com.reports.ExtentReport;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {

   /* @BeforeSuite
    public void setUpSuite(){
        ExtentReport.initReports();
    }

    @BeforeMethod
    public void setup(Method m){
        ExtentReport.createTest(m.getName());

    }

    @AfterSuite
    public void tearDownReport(){
        ExtentReport.tearDownReports();

    }*/
}
