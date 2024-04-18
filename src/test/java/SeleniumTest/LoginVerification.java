package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginVerification {
    WebDriver driver;


    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        switch (browser.toLowerCase()){
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            default:
                System.out.println("doesnt match");
                break;

        }

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void login() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(actualTitle, expectedTitle, "title mismatch");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }

    @Test(dependsOnMethods = "login",priority = 4)
    public void positive(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));

        userName.click();
        userName.sendKeys("Admin");


        password.click();
        password.sendKeys("admin123");

        password.sendKeys(Keys.ENTER);

        WebElement picture =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/img"));

        Assert.assertTrue(picture.isDisplayed());


    }

    @Test(dependsOnMethods = "login",priority = 1)
    public void negativeTest1(){


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));

        userName.click();
        userName.sendKeys("");


        password.click();
        password.sendKeys("admin123");

        password.sendKeys(Keys.ENTER);

        WebElement message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));

       String actualText = message.getText();

       String expectedText ="Required";

        Assert.assertEquals(actualText,expectedText,"Does not match");

    }

    @Test(dependsOnMethods = "login",priority = 2)
    public void negativeTest2(){


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));

        userName.click();
        userName.sendKeys("");


        password.click();
        password.sendKeys("admin143");

        password.sendKeys(Keys.ENTER);

        WebElement message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));

        String actualText = message.getText();

        String expectedText ="Required";

        Assert.assertEquals(actualText,expectedText,"Does not match");

    }
    @Test(dependsOnMethods = "login",priority = 3)
    public void negativeTest3(){


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));

        userName.click();
        userName.sendKeys("Admin");


        password.click();
        password.sendKeys("asdas");

        password.sendKeys(Keys.ENTER);

        WebElement message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));

        String actualText = message.getText();

        String expectedText ="Invalid credentials";

        Assert.assertEquals(actualText,expectedText,"Does not match");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        if (driver != null) {

            //   driver.close();
            driver.quit();
        }


    }
}
