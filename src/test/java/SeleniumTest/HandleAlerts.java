package SeleniumTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class HandleAlerts {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
    }

    @Test(priority =1)
    public void testHandleAllerts() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actual = driver.getCurrentUrl();
        String expected = "https://demoqa.com/alerts";
        Assert.assertEquals(actual, expected);

        driver.findElement(By.id("alertButton")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("alert is about: " + alert.getText());

        alert.accept();

    }

    @Test(priority = 2)
    public void testHandleAllerts2() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement button = driver.findElement(By.id("timerAlertButton"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",button);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"timerAlertButton\"]")));
        driver.findElement(By.id("timerAlertButton")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert is about: " + alert.getText());

        alert.accept();
    }

    @Test(priority = 3)
    public void testHandleAllerts3() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement button =  driver.findElement(By.id("confirmButton"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",button);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"confirmButton\"]")));
        driver.findElement(By.id("confirmButton")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert is about: " + alert.getText());
        alert.dismiss();

        String declineMessage = driver.findElement(By.id("confirmResult")).getText();
        System.out.println(declineMessage);
        String DeclineView = "Cancel";
        Assert.assertTrue(declineMessage.contains(DeclineView));

    }

    @Test(priority = 4)
    public void testHandleAllerts4() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement button = driver.findElement(By.id("promtButton"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",button);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("promtButton")));
        driver.findElement(By.id("promtButton")).click();
        Alert alert = driver.switchTo().alert();
        String name = "abcdef";
        alert.sendKeys(name);
        alert.accept();
        String result = driver.findElement(By.id("promptResult")).getText();
        System.out.println(result);
        String resultView = name;
        Assert.assertTrue(result.contains(resultView));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}