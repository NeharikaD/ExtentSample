package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DemoClass {
    public static void main(String[] args) throws IOException {
        ExtentReports extentReport = new ExtentReports();
        File file = new File("C:/Users/Neharika/IdeaProjects/PracticeExtentMaven/report.html");
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:/Users/Neharika/IdeaProjects/PracticeExtentMaven/report.html");
//    or
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReport.attachReporter(sparkReporter);

        ExtentTest testOne = extentReport.createTest("Test - 1");
        testOne.pass("This is pass");
        ExtentTest testTwo = extentReport.createTest("Test - 2");
        testTwo.log(Status.FAIL,"This is fail");
        extentReport.createTest("Test - 3").skip("This is skipped");

        extentReport
                .createTest("Test - 0")
                .log(Status.INFO, "info")
                .log(Status.PASS, "pass")
                .log(Status.INFO, "info")
                .log(Status.WARNING, "warning")
                .log(Status.FAIL, "fail")
                .log(Status.PASS, "pass")
                .log(Status.SKIP, "skip");

        extentReport.flush();
        Desktop.getDesktop().browse(file.toURI());
    }
}
