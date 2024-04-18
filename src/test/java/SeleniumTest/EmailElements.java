package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailElements {
    WebDriver driver;


    public EmailElements(WebDriver driver) {
        this.driver = driver;
    }
    By signInButton = By.xpath("//*[@id=\"login-container\"]/a");
    By userName = By.xpath("//*[@id=\"login-username\"]");

    By password = By.xpath("//*[@id=\"login-passwd\"]");

    By nextButton = By.xpath("//*[@id=\"login-signin\"]");
    By mailButton = By.xpath("//*[@id=\"ybarMailLink\"]");
    By composeButton =By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/nav/div/div[1]/a");

    By recipientDetails = By.xpath("//*[@id=\"message-to-field\"]");

    By subject = By.xpath("//*[@id=\"compose-subject-input\"]");

    By emailBody =By.xpath("//*[@id=\"editor-container\"]/div[1]");

    By sendButton = By.xpath("//button[@data-test-id='compose-send-button']");



    public void clickSignIn(){
        driver.findElement(signInButton).click();
    }

    public void enterUserName(String str){
    driver.findElement(userName).click();
    driver.findElement(userName).sendKeys(str);

}
    public void enterPassword(String str){
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(str);
    }

    public void clickNext(){
        driver.findElement(nextButton).click();
    }
    public void clickMail(){
        driver.findElement(mailButton).click();
    }
    public void clickCompose(){
        driver.findElement(composeButton).click();
    }
    public void enterRecipientEmail(String str){
        driver.findElement(recipientDetails).click();
        driver.findElement(recipientDetails).sendKeys(str);
    }

    public void enterSubject(String str){
        driver.findElement(subject).click();
        driver.findElement(subject).sendKeys(str);
    }

    public void enterBodyText(String str){
        driver.findElement(emailBody).click();
        driver.findElement(emailBody).sendKeys(str);

    }
    public void clickSend(){
        driver.findElement(sendButton).click();
    }


}
