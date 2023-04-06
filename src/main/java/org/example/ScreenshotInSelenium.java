package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class ScreenshotInSelenium {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        Utils.captureScreenshots(driver, "img - 1.jpg");

        //or
//        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        Files.copy(file.toPath(), new File("C:/Users/Neharika/IdeaProjects/PracticeExtentMaven/SampleScreenshots/amazonscreenshot.jpg").toPath());
        driver.quit();
    }
}
