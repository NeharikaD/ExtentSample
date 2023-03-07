import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SceenShots {

    public static WebDriver driver;
    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("C:/Users/Neharika/IdeaProjects/PracticeExtentMaven/report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        String path = captureScreenshots("a-z img.jpg");

        //test level screenshots
        extentReports.createTest("Screenshot test1","This is to attaching a screen shot to the test for test level")
                .info("Just a message")
                .addScreenCaptureFromPath(path);

        extentReports.createTest("Screenshot test2","This is to attaching a screen shot to the test")
                .info("Just a message").addScreenCaptureFromPath(path, "amazon home page");

        //multiple screenshots
        extentReports.createTest("Screenshot test3","This is to attaching a screen shot to the test")
                .info("Just a message").addScreenCaptureFromPath(path, "amazon home page1")
                .info("Just a message").addScreenCaptureFromPath(path, "amazon home page2")
                .info("Just a message").addScreenCaptureFromPath(path, "amazon home page3")
                .info("Just a message").addScreenCaptureFromPath(path, "amazon home page4");

        //log level screenshots
        extentReports.createTest("Screenshot test4","This is to attaching a screen shot to the test for log level")
                .info("Just a message")
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "amazon home page").build());

        extentReports.createTest("Screenshot test5","This is to attaching a screen shot to the test for log level")
                .info("Just a message")
                .fail("One - 1", MediaEntityBuilder.createScreenCaptureFromPath(path).build())
                .fail("One - 2", MediaEntityBuilder.createScreenCaptureFromPath(path, "amazon home page").build());

        Throwable t = new Throwable("This is exception");
        extentReports.createTest("Screenshot test6","This is to attaching a screen shot to the test for log level")
                .info("Just a message")
                .fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path).build())
                .fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path, "amazon home page").build());



        extentReports.flush();
        driver.quit();
        Desktop.getDesktop().browse(file.toURI());
    }

    public static String captureScreenshots(String fileName) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(file.toPath(), new File("C:/Users/Neharika/IdeaProjects/PracticeExtentMaven/SampleScreenshots/"+fileName+"").toPath());
        return file.getAbsolutePath();
    }
}
