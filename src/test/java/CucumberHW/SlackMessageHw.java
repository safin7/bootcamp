package CucumberHW;

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

public class SlackMessageHw {
    WebDriver driver;
    SlackElements slackElements;


    @Given("I am on slack webpage")
    public void i_am_on_slack_webpage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://slack.com");
        slackElements = new SlackElements(driver);
        String title = driver.getTitle();
        String expected = "Slack is your productivity platform | Slack";
        Assert.assertEquals(title,expected,"mismatch");
    }

    @When("I click on the \"Sign In\" button")
    public void i_click_on_sign_in_button(){
        slackElements.clickSignIn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Then("I should be taken to the login Page")
    public void i_should_be_taken_to_login_page(){
        String loginTitle = driver.getTitle();
        String expected2 = "Login | Slack";
        Assert.assertEquals(loginTitle,expected2,"Mismatch");

    }
    @When("I click on \"sign in manually instead\"")
    public void i_click_on_sign_in_manually_instead(){
        slackElements.clickManualSignIn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Then("I should be taken to the Workspace login page")
    public void i_should_be_taken_to_workspace_login_page(){
      String workSpaceTitle =  driver.getTitle();
      String expected3 = "Find your workspace | Slack";
      Assert.assertEquals(workSpaceTitle,expected3,"mismatch");

    }
    @And("I enter my workspace name and submit")
    public void i_enter_my_workspace_name_and_submit(){
        slackElements.clickWorkSpaceInput("creativecodingcollect");
        slackElements.clickContinue();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @And ("I click on \"sign in with a password instead\"")
    public void i_click_on_sign_in_with_a_password_instead(){
        slackElements.clickSignInManuallyWithPassword();
    }

    @And("I enter my email and password and submit")
    public void i_enter_my_email_and_password_and_submit(){
        slackElements.enterEmail("safin.manutd@gmail.com");
        slackElements.enterPassword("Mohammed_safin7");
        slackElements.clickSignIn2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        slackElements.clickUseSlackInBrowser();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Then("I should be taken to my workspace")
    public void i_should_be_taken_to_my_workspace() {
        String actualTitle4 = driver.getTitle();
        String expectedWorkspaceTitle = "Slack";
        Assert.assertEquals(actualTitle4,expectedWorkspaceTitle,"mismatch");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

   @And("I select recipient")
    public void i_select_recipient(){
        slackElements.selectRecipient();
   }

   @And("I enter message in the input and click send")
    public void i_enter_message_in_the_input_and_click_send(){
        slackElements.enterMessage("This is an automated Message");
        slackElements.clickSend();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

   }

   @Then("Message should be sent to recipient")
    public void message_should_be_sent_to_recipient(){
        String actualMessage =  driver.findElement(By.xpath("//*[@id=\"1712607599.282469\"]/div/div/div/div/div[2]")).getText();
        String expectedMessage = "This is an automated Message";
        Assert.assertEquals(actualMessage,expectedMessage,"Mismatch");
        driver.quit();

   }






}
