package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.rmi.StubNotFoundException;
import java.time.format.DecimalStyle;

public class LogLevelEvents {
    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("C:/Users/Neharika/IdeaProjects/PracticeExtentMaven/report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);

        ExtentTest test = extentReports.createTest("Test - One");
        test.pass("pass");

        extentReports.createTest("Text Based Test")
                .log(Status.INFO, "this is normal info")
                .log(Status.INFO, "<b>this is bold info</b>")
                .log(Status.INFO, "<i>this is italic info</i>")
                .log(Status.INFO, "<b><i>This is bold & italic info</i></b>");

        String xmlData = "<menu id=\"file\" value=\"File\">\n" +
                "  <popup>\n" +
                "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n" +
                "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n" +
                "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n" +
                "  </popup>\n" +
                "</menu>";

        String jsonData = "{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}";

        //this xmlData will be treated as a xml code, so it won't be visible on the details filed of report(it's only visible on the console window of dom structure when we inspect)
        extentReports.createTest("XML based text")
                        .log(Status.INFO, xmlData);

        //this jsonData will be displayed in the form of normal text(for proper formatting paste that details field in online json formatter)
        extentReports.createTest("JSON based text")
                .log(Status.INFO, jsonData);

        //to avoid above complications we can do as follows
        extentReports.createTest("XML based text")
                        .log(Status.INFO, MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
        //or
        extentReports.createTest("JSON based text")
                .info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));

        extentReports.flush();
        Desktop.getDesktop().browse(file.toURI());
    }
}
