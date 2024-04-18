package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WidgetTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();
    }

    @Test
    public void testWidgets() throws InterruptedException {
        WebElement startButton = driver.findElement(By.id("startStopButton"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", startButton);


        startButton.click();

        Thread.sleep( 3000);

        startButton.click();

        WebElement progressBar = driver.findElement(By.className("progress-bar"));
        String progress = progressBar.getAttribute( "aria-valuenow");
        System.out.println("Progress after 3 seconds: " + progress + "%");

        Assert.assertNotEquals(progress, "0",  "Progress bar did not change.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
