package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Hostname;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() {
        driver.get("https://www.google.com"); // opening google.com website
        String ActualTitle = driver.getTitle(); // getting the title of the page
        String ExpectedTitle = "Google";

        Assert.assertEquals(ActualTitle, ExpectedTitle, "Title not match"); // assert for verification
    }

    @Test(dependsOnMethods = "firstTest")
    public void secondTest() {
        driver.findElement(By.name("q")).click(); // searching for the text box with google and clicking it
        driver.findElement(By.name("q")).sendKeys("selenium tutorial for beginners"); // sending keys
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER); // assuming after text we hitting the enter

        String ActualTitle = driver.getTitle(); // getting the title of the google to verify
        String ExpectedTitle = "selenium tutorial for beginners - Google Search";

        Assert.assertEquals(ActualTitle, ExpectedTitle, "Title not match"); // assert for verification
    }

    @Test(dependsOnMethods = "secondTest")
    public void thirdTest() {
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[5]/div/div/div/div[1]/div/div/span/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String companyName = driver.findElement(By.xpath("//*[@id=\"masthead\"]/div/div/p/a")).getText();
        String expected = "ArtOfTesting";

        Assert.assertEquals(companyName, expected, "company does not match");

    }

    @AfterClass
    public void tearDown() throws Exception {
        if (driver != null) {

         //   driver.close();
            driver.quit();
        }

    }
}
