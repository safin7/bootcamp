package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondSeleniumTestHW {
    WebDriver driver;

    @BeforeClass
    public void setUpt() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void amazonSearch() {
        // Navigate to Amazon
        driver.get("https://www.amazon.com");
        String PageTitle = driver.getTitle();

// Assert that the title is "Amazon.com"
        Assert.assertEquals(PageTitle, "Amazon.com. Spend less. Smile more.", "Title not match");

// Find the search box and enter "socks"
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("socks");

// Submit the search
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Wait for the search results to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-main-slot.s-result-list")));

        String SockSearch = driver.getTitle();
        String SocksSearchResult = "Amazon.com : socks";
        Assert.assertEquals(SockSearch, SocksSearchResult, "Title not match");

// Count the number of products in the first page
        List<WebElement> productResults = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

        int numberOfProducts = productResults.size();

// Assert the number of products (this assertion depends on your test criteria)
        Assert.assertTrue(numberOfProducts >= 48, "Product count is not greater than 0");

// Print out the number of found products
        System.out.println("Number of products found: " + numberOfProducts);


        List<WebElement> productDescription = driver.findElements(By.xpath("//span[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
        int countSocks = 0;
        for (WebElement titleElement : productDescription) {
            String titleText = titleElement.getText();
            if (titleText.toLowerCase().contains("socks")) {
                countSocks++;
            }
        }

// Print out the number of product titles containing the word "Socks"
        System.out.println("Number of products with 'Socks' in the title: " + countSocks);

        System.out.println(" ");

// Find product titles in the first page of search results
        List<WebElement> ProductTitles = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base']"));

        Set<String> uniqueTitles = new HashSet<>();
        for (WebElement ProductTitleElement : ProductTitles) {
            String titleText = ProductTitleElement.getText();
            uniqueTitles.add(titleText);
        }

// Print out all unique product titles
        System.out.println("Unique product titles found: ");
        for (String title : uniqueTitles) {
            System.out.println(title);
        }

        }








    @AfterClass
    public void tearDown() throws Exception {
        if (driver != null) {

            //   driver.close();
            driver.quit();
        }

    }



}
