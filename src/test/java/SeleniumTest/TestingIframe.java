package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class TestingIframe {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testIframe() {
        driver.switchTo().frame("frame1");

        String  frameText =driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("text in the frame is "+ frameText);

        String expected = "This is a sample page";
        Assert.assertEquals(frameText,expected,"Mismatch");

        driver.switchTo().frame("frame2");

        String frame2Text = driver.findElement(By.id("sampleHeading")).getText();
        String  expected2 = "This is a sample page";
        Assert.assertEquals(frame2Text,expected2,"Mismatch");

        System.out.println("text in the frame is "+ frame2Text);
        driver.switchTo().defaultContent();




    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}