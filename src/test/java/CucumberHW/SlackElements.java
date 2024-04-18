package CucumberHW;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class SlackElements {
    WebDriver driver;

    public SlackElements(WebDriver driver) {
        this.driver = driver;
    }

    By signInButton = By.xpath("/html/body/header/nav[1]/div/nav/div[3]/a[1]");
    By signInManually = By.xpath("//*[@id=\"get_started_app_root\"]/div[1]/div[2]/div[4]/span/a");
    By workSpaceInput = By.xpath("//*[@id=\"domain\"]");
    By continueButton = By.xpath("//*[@id=\"page_contents\"]/div/div/div[1]/div[2]/form/button");
    By manualPassword = By.xpath("//*[@id=\"page_contents\"]/div/div/div[2]/div[3]/div[4]/span/a");

    By emailInputButton = By.xpath("//*[@id=\"email\"]");

    By passwordInputButton = By.xpath("//*[@id=\"password\"]");

    By signInButton2 = By.xpath("//*[@id=\"signin_btn\"]");


    By slackInBrowser =By.xpath("//*[@id=\"page_contents\"]/div/div/div[2]/p/a");


    By harsh = By.xpath("//*[@id=\"D06S3R2QAHJ\"]/div/div");

    By messageInputBox = By.xpath("/html/body/div[2]/div/div/div[4]/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[1]");

    By sendMessage = By.xpath("/html/body/div[2]/div/div/div[4]/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[2]/div/div/div[2]/div/div/div/div[3]/div[3]/span/button[1]");

    public void clickSignIn(){
        driver.findElement(signInButton).click();
    }
    public void clickManualSignIn(){
        driver.findElement(signInManually).click();
    }
    public void clickWorkSpaceInput(String str){
        driver.findElement(workSpaceInput).click();
        driver.findElement(workSpaceInput).sendKeys(str);
    }
    public void clickContinue(){
        driver.findElement(continueButton).click();
    }
    public void clickSignInManuallyWithPassword(){
        driver.findElement(manualPassword).click();


    }
    public void enterEmail(String str){
        driver.findElement(emailInputButton).click();
        driver.findElement(emailInputButton).sendKeys(str);
    }
    public void enterPassword(String str){
        driver.findElement(passwordInputButton).click();
        driver.findElement(passwordInputButton).sendKeys(str);
    }
    public void clickSignIn2(){
        driver.findElement(signInButton2).click();
    }

    public void clickUseSlackInBrowser(){
        driver.findElement(slackInBrowser).click();
    }


    public void selectRecipient(){
        driver.findElement(harsh).click();
    }

    public void enterMessage(String str){
        driver.findElement(messageInputBox).click();
        driver.findElement(messageInputBox).sendKeys(str);

    }
    public void clickSend(){
        driver.findElement(sendMessage).click();

    }





}
