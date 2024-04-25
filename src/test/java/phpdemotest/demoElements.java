package phpdemptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class demoElements {
    WebDriver driver;
    By firstName = By.xpath("//*[@id=\"swup\"]/section[1]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/div/input");
    By lastName = By.xpath("//*[@id=\"swup\"]/section[1]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div/input");
    By businessName = By.xpath("//*[@id=\"swup\"]/section[1]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[2]/input");
    By email = By.xpath("//*[@id=\"swup\"]/section[1]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[3]/input");
    By num1 = By.id("numb1");
    By num2 = By.id("numb2");
    By resultBox = By.xpath("//*[@id=\"number\"]");

    By submitButton = By.xpath("//*[@id=\"demo\"]");
    By confirmation = By.xpath("//*[@id=\"swup\"]/section[1]/div/div/div[1]/div/div/div/div/div/div/div/div[3]/h2/strong");

    public demoElements(WebDriver driver) {
        this.driver = driver;
    }


    public void enterFirstName(String str){
        driver.findElement(firstName).click();
        driver.findElement(firstName).sendKeys(str);

    }
    public void enterLastName(String str){
        driver.findElement(lastName).click();
        driver.findElement(lastName).sendKeys(str);

    }
    public void enterBusinessName(String str){
        driver.findElement(businessName).click();
        driver.findElement(businessName).sendKeys(str);

    }
    public void enterEmail(String str){
        driver.findElement(email).click();
        driver.findElement(email).sendKeys(str);

    }
    public String calculateSum(){
        String value1 = driver.findElement(num1).getAttribute("value");
        String value2 = driver.findElement(num2).getAttribute("value");

        int num1Value = Integer.parseInt(value1);
        int num2Value = Integer.parseInt(value2);

        int sum = num1Value + num2Value;

        String result = String.valueOf(sum);
        return result;
    }
    public void enterSum(String string){
        driver.findElement(resultBox).sendKeys(string);
    }

    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }





}
