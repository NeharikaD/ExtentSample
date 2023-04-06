package org.example;//different attributes for test :
//                               Author, Category, Device

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Attributes {
    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("C:/Users/Neharika/IdeaProjects/PracticeExtentMaven/report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);

        extentReports.createTest("Test - 1", "Nothing to say")
                .assignAuthor("Hermione Granger")
                .assignCategory("Sanity")
                .assignDevice("Chrome 109")
                .pass("this is pass");

        extentReports.createTest("Test - 2", "Nothing to say")
                .assignAuthor("Harry Potter")
                .assignCategory("Smoke")
                .assignDevice("Edge 109")
                .fail("this is fail");

        extentReports.createTest("Test - 3", "Nothing to say")
                .assignCategory("Regression")
                .assignAuthor("Ron Weasley")
                .pass("this is pass");

        extentReports.createTest("Test - 4", "Nothing to say")
                .assignAuthor("Ron Weasley")
                .assignCategory("Smoke")
                .assignDevice("Firefox 60")
                .assignAuthor("Hermione Granger")
                .assignCategory("Sanity")
                .assignDevice("Chrome 109")
                .fail("this is fail");

        extentReports.createTest("Test - 5", "Nothing to say")
                .assignAuthor("Ron Weasley", "Rebbecca", "John")
                .assignCategory("Smoke", "Sanity")
                .assignDevice("Firefox 60","Chrome 109","Edge 99")
                .assignAuthor("Hermione Granger")
                .assignCategory("Regression")
                .assignDevice("Chrome 109")
                .pass("this is pass");

        extentReports.createTest("Test - 6", "Nothing to say")
                .assignAuthor(new String[]{"Ron Weasley","Harry Potter"})
                .assignCategory(new String[]{"Sanity","Smoke", "Integration"})
                .assignDevice(new String[]{"Firefox 60","Chrome 99"})
                .pass("this is pass");


        extentReports.flush();
        Desktop.getDesktop().browse(file.toURI());
    }
}