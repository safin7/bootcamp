package CucumberTestingDemo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GoogleSearchSteps {

    private WebDriver driver;

    @Given("I am on the google search page")
    public void i_am_on_the_google_search_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String searchTerm) {
        driver.findElement(By.name("q")).sendKeys(searchTerm);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @When("I click on the Amazon link")
    public void i_click_on_the_amazon_link() throws InterruptedException {
        Thread.sleep( 2000);

        driver.findElements(By.cssSelector("h3")).stream().filter(webElement -> webElement.getText().contains("Amazon"))
                .findFirst()
                .ifPresent(webElement -> webElement.findElement(By.xpath("..")).click());
    }
    @Then("I should be taken to the Amazon website")
    public void i_should_be_taken_to_the_amazon_website()  {
        String actual =driver.getTitle();
        String expected = "Amazon.com. Spend less. Smile more.";

        Assert.assertEquals(actual,expected,"mismatch");
        driver.quit();
    }


}
