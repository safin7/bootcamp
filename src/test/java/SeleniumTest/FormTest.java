package SeleniumTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTest {
    WebDriver driver;
    FormElements FormElements;

    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        FormElements = new FormElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testForm() throws Exception {
        String title = driver.getTitle();
        String expected = "DEMOQA";
        Assert.assertEquals(title, expected);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        FormElements.enterFirstName("John");
        FormElements.enterLastName("Doe");
        FormElements.enterEmail("johndoe@example.com");

        WebElement maleRadioButton = driver.findElement(By.id("gender-radio-1"));
        Actions actions = new Actions(driver);
        actions.moveToElement(maleRadioButton).click().perform();


        FormElements.enterMobile("1232233434");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateOfBirthInput")));
        WebElement DOB = driver.findElement(By.id("dateOfBirthInput"));
        DOB.click();

        Select monthSelect = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        monthSelect.selectByVisibleText("May");

        Select yearSelect = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        yearSelect.selectByVisibleText("1990");


        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[3]")));
        WebElement day = driver.findElement(
                By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[3]"));
        day.click();

        FormElements.enterSubject("Maths And Physics");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
                By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[1]"))));
        WebElement hobby = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[1]"));
        hobby.click();

        String path = "C:/Users//Harsh/Desktop/portrait-casual-caucasian-man-d-cartoon-style-generative-ai_601748-54043.jpg";
        WebElement uploadFile = driver.findElement(By.id("uploadPicture"));
        uploadFile.sendKeys(path);

        FormElements.enterAddress("123 Main street");

        WebElement stateDropdown = driver.findElement(By.id("state"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateDropdown);

        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("react-select-3-option-0")).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("react-select-4-option-0")).click();

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

    }

    @AfterClass
    public void cleanUp(){
        if (driver != null){
            driver.quit();
        }
    }


}