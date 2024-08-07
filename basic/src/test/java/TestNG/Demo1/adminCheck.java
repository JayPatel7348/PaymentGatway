package TestNG.Demo1;

import Pages.AdminLogin;
import Pages.screenShot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class adminCheck {

   // public WebDriver driver;

    ChromeDriver driver;
    AdminLogin al;
    @BeforeMethod
    public void browserLaunch()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://paymenthub.elaunchinfotech.in/secureAdmin/login");
        al= new AdminLogin(driver);
    }
    @AfterMethod
    public void teardown()
    {
       driver.quit();
    }

    @Test(priority=1,groups="login")
    public void validLogin() throws IOException, InterruptedException {
        al.enterUserName("securepayadmin@gmail.com");
        al.enterPassword("admin@123");
        al.clickSignIn();

        Thread.sleep(4000);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Admin | Dashboard");
        screenShot ss=new screenShot();
        ss.screnshot(driver);

    }
    @Test(priority=2,groups="login")
    public void invalidLogin() throws IOException, InterruptedException {
        al.enterUserName("securepayadmin1@gmail.com");
        al.enterPassword("admin@123");
        al.clickSignIn();

        Thread.sleep(4000);
        al.setToasterMsg();
        Assert.assertEquals(al.setToasterMsg(),"Email is not registered!");
        screenShot ss=new screenShot();
        ss.screnshot(driver);
    }

    @Test(priority=3,groups="login")
    public void invalidPasswordLogin() throws IOException, InterruptedException {
        al.enterUserName("securepayadmin@gmail.com");
        al.enterPassword("admin@1234");
        al.clickSignIn();

        Thread.sleep(4000);
        al.setToasterMsg();
        Assert.assertEquals(al.setToasterMsg(),"Incorrect password!");
        screenShot ss=new screenShot();
        ss.screnshot(driver);
    }

    @Test(priority=4,groups="login")
    public void showHidePasswordLogin() throws IOException, InterruptedException {
        al.enterUserName("securepayadmin@gmail.com");
        al.enterPassword("admin@1234");

        Thread.sleep(1000);
        driver.findElement(By.className("show-hide")).isEnabled();
        driver.findElement(By.className("show-hide")).click();
        Thread.sleep(1000);
        String pswd=driver.findElement(By.xpath("//input[@placeholder='Enter password']")).getAttribute("value");
        Assert.assertEquals(pswd,"admin@1234");


        screenShot ss=new screenShot();
        ss.screnshot(driver);
    }

    @Test(priority=5,groups="login")
    public void blankLogin() throws IOException, InterruptedException {
        al.enterUserName("");
        al.enterPassword("");
        al.clickSignIn();

        Thread.sleep(4000);
        al.setErrorMsgEmail();
        Assert.assertEquals("Email address is required", al.setErrorMsgEmail());
        al.setErrorMsgPswd();
        Assert.assertEquals("Password is required", al.setErrorMsgPswd());

        screenShot ss=new screenShot();
        ss.screnshot(driver);
    }

    @Test(priority=6)
    public void invalidCredentialLogin() throws IOException, InterruptedException {
        al.enterUserName("sdfssdfs");
        al.enterPassword("sfdsfsf");
        al.clickSignIn();

        Thread.sleep(4000);
        al.setErrorMsgEmail();
        Assert.assertEquals("Must be a valid email address", al.setErrorMsgEmail());
        al.setErrorMsgPswd();
        Assert.assertEquals("Password must be at least 8 characters long", al.setErrorMsgPswd());

        screenShot ss=new screenShot();
        ss.screnshot(driver);
    }



}
