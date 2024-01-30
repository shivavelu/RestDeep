package com.listeners;

import com.reports.ExtentReport;
import com.reports.Extentlogger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    public void onFinish(ISuite suite) {
        ExtentReport.tearDownReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Extentlogger.pass(result.getName()+"is passed");
    }

   @Override
    public void onTestFailure(ITestResult result) {
        Extentlogger.fail(String.valueOf(result.getThrowable()));
    }


}
