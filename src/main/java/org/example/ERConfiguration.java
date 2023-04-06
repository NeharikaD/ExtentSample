package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ERConfiguration {
    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("C:/Users/Neharika/IdeaProjects/PracticeExtentMaven/report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        /*
//        sparkReporter.config().setTheme(Theme.DARK);
//        sparkReporter.config().setReportName("Report Name");
//        sparkReporter.config().setDocumentTitle("Doc Title");
//        sparkReporter.config().setTimeStampFormat("dd-MM-yyyy hh-mm-ss");
//        sparkReporter.config().setCss(".badge-primary{background-color: #ffc107}");
//        sparkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
        *///or
        /*
//        ExtentSparkReporterConfig config = sparkReporter.config();
//        config.setTheme(Theme.DARK);
//        config.setReportName("Report Name");
//        config.setDocumentTitle("Doc Title");
//        config.setTimeStampFormat("dd-MM-yyyy hh-mm-ss");
//        config.setCss(".badge-primary{background-color: #ffc107}");
//        config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");
          *///or
        //best way of use is json
        sparkReporter.loadJSONConfig(new File("C:\\Users\\Neharika\\IdeaProjects\\PracticeExtentMaven\\src\\test\\extentreports-config.json"));
        //or
//        sparkReporter.loadXMLConfig(new File("C:\\Users\\Neharika\\IdeaProjects\\PracticeExtentMaven\\src\\test\\extentreports-config.xml"));
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

        extentReports.flush();
        Desktop.getDesktop().browse(file.toURI());
    }
}
