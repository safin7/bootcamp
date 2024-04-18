package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class EmailTest {
    WebDriver driver;

    EmailElements emailElements;


    @BeforeClass
    public void setUp() throws  Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        emailElements = new EmailElements(driver);
    }

    @Test
    public void sendEmail(){
       String title =  driver.getTitle();
       String expected = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
       Assert.assertEquals(title,expected,"Incorrect title");


       emailElements.clickSignIn();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       String title2 = driver.getTitle();
       String expected2 = "Yahoo";
       Assert.assertEquals(title2,expected2,"Incorrect title");

       emailElements.enterUserName("muddin23955@yahoo.com");
       emailElements.clickNext();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
       emailElements.enterPassword("Mohammed_safin7");
       emailElements.clickNext();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       String title3 =  driver.getTitle();
       String expected3 = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
       Assert.assertEquals(title3,expected3,"Incorrect title");

       emailElements.clickMail();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       String title4 = driver.getTitle();
       String expected4 = "(No new emails) - muddin23955@yahoo.com - Yahoo Mail";
       Assert.assertEquals(title4,expected4,"Incorrect title");

       emailElements.clickCompose();
       emailElements.enterRecipientEmail("harsh@collaboraitinc.com");
       emailElements.enterSubject("Automated email");
       emailElements.enterBodyText("Good evening, this is an automated email sent by Md Rifat Uddin. Thank you have a nice day!");
       emailElements.clickSend();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       String messageSent = driver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div/div[2]")).getText();
       String expectedMessage = "Your message has been sent.";

       Assert.assertEquals(messageSent,expectedMessage,"Email was not sent");
    }
    @AfterClass
    public void cleanUp(){
        if (driver != null){
            driver.quit();
        }
    }

}
