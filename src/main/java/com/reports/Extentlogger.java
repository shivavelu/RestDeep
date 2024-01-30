package com.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class Extentlogger {

    private Extentlogger(){

    }
    public static void pass(String message){
        ExtentManager.getTest().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    public static void info(String message){
        ExtentManager.getTest().info(message);
    }

    public static void logReponse(String message)
    {
        ExtentManager.getTest().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
    }

    public static void logRequest(RequestSpecification requestSpecification){
        QueryableRequestSpecification query= SpecificationQuerier.query(requestSpecification);
        info("Request Details Below");
        ExtentManager.getTest().info(MarkupHelper.createCodeBlock(query.getBody(), CodeLanguage.JSON));
        for(Header header:query.getHeaders()){
            info(header.getName()+":"+header.getValue());
        }
    }


}
