package org.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class Utils {
    public static void captureScreenshots(WebDriver driver, String fileName) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(file.toPath(), new File("C:/Users/Neharika/IdeaProjects/PracticeExtentMaven/SampleScreenshots/"+fileName+"").toPath());
    }
}
