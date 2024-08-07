package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLogin {

    public WebDriver driver;

    public AdminLogin(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Enter email address']")
    WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Sign in']")
    WebElement signInBtn;

    @FindBy(xpath="(//*[@class='pt-1 text-danger'])[1]")
    WebElement errorMsgEmail;

    @FindBy(xpath="(//*[@class='pt-1 text-danger'])[2]")
    WebElement errorMsgPswd;

    @FindBy(xpath="//*[@class='Toastify__toast-body']")
    WebElement toaster;




    // Method to enter username
    public void enterUserName(String username) {
        userName.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    // Method to click on sign in button
    public void clickSignIn() {
        signInBtn.click();
    }

    public String setErrorMsgEmail()
    {
        String erMsgEmail=errorMsgEmail.getText();
        return erMsgEmail;
    }

    public String setErrorMsgPswd()
    {
        String erMsgPswd=errorMsgPswd.getText();
        return erMsgPswd;
    }

    public String setToasterMsg(){
        String toasterMsg=toaster.getText();
        return toasterMsg;
    }



}
