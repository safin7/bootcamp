package phpdemptest;

import CucumberHW.SlackElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class DemoSteps {

    WebDriver driver;
    demoElements elements;

   @Given("I am on the demo page")
    public void i_am_on_the_demo_page(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.get("https://phptravels.com/demo/");
       elements = new demoElements(driver);
       String title = driver.getTitle();
       String expected = "Book Your Free Demo Now - Phptravels";

       Assert.assertEquals(title,expected,"mismatch");
   }

   @When("I enter my information")
    public void when_i_enter_my_information(){
       elements.enterFirstName("Harsh");
       elements.enterLastName("Trivedi");
       elements.enterBusinessName("CollaboraIT");
       elements.enterEmail("harsh@collaboraitinc.com");
       String sum = elements.calculateSum();
       elements.enterSum(sum);

   }
   @And("I click on submit")
    public void i_click_on_submit(){
       elements.clickSubmit();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   }

   @Then("I should get a confirmation of submission")
    public void i_should_get_a_confirmation_of_submission(){
     String actualMessage =  driver.findElement(By.xpath("//*[@id=\"swup\"]/section[1]/div/div/div[1]/div/div/div/div/div/div/div/div[3]/h2/strong")).getText();

     String expectedMessage = " Thank you!";

     Assert.assertEquals(actualMessage,expectedMessage,"mismatch");


   }



}
