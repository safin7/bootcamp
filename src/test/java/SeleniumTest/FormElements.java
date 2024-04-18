package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormElements {
    WebDriver driver;


    public  FormElements(WebDriver driver) {
        this.driver =driver;
    }

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");

    By email = By.id("userEmail");

    By gender = By.id("gender-radio-1");

    By hobby = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label");

    By mobile = By.id("userNumber");

    By dateOfBirth = By.id("dateOfBirthInput");
    By subject = By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]");
    By address = By.xpath("//*[@id=\"currentAddress\"]");
    By state = By.xpath("//*[@id=\"state\"]/div/div[1]");

    public void enterFirstName(String fname){
        driver.findElement(firstName).sendKeys(fname);

    }
    public void enterLastName(String lname){
        driver.findElement(lastName).sendKeys(lname);

    }
    public void enterEmail(String userEmail){
        driver.findElement(email).sendKeys(userEmail);

    }

    public void selectGender(){
        driver.findElement(gender).click();

    }
    public void selectHobbies(){
        driver.findElement(hobby).click();

    }

    public void enterMobile(String mobileNumber){
        driver.findElement(mobile).sendKeys(mobileNumber);
    }



    public void enterSubject (String sub){
        driver.findElement(subject).sendKeys(sub);
        driver.findElement(subject).sendKeys(Keys.ENTER);

    }
    public void chooseFile(){

    }

    public void enterAddress(String add){
        driver.findElement(address).sendKeys(add);
    }

    public void selectState(){
        driver.findElement(state).click();


    }



}
//WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
//WebElement lastName = driver.findElement(By.xpath(""));
//WebElement email = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
