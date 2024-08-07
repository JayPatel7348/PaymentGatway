package TestNG.Demo1;

import Pages.AdminLogin;
import Pages.PaymentModulePage;
import Pages.SwitchWindow;
import Pages.screenShot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class PaymentCheck {


    ChromeDriver driver;
    PaymentModulePage pm;
    SwitchWindow sw=new SwitchWindow();
    screenShot ss=new screenShot();
    @BeforeMethod
    public void browserLaunch()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://paymenthub.elaunchinfotech.in/payment-sample");
        pm= new PaymentModulePage(driver);
    }
    @AfterMethod
    public void teardown()
    {
       driver.quit();
    }


    @Test(groups="oppi wallet")
    public void testDepositFormSubmission() throws InterruptedException, IOException {
        // Example usage
        pm.setDepositId("123");
        pm.setDepositName("Test Deposit");
        pm.setDepositAmount("3");
        pm.selectDepositType("Deposit");
        pm.selectCurrency("6687ad11fd30994303056038");
        pm.submitForm();

        Thread.sleep(2000);

       // sw=new SwitchWindow();
        sw.switchWindow1(driver);

        Thread.sleep(3000);
       // pm.paymentModuleSelect();
        pm.selectCurrencyIframe("TRX");

        Thread.sleep(1000);

        Assert.assertEquals(pm.setValidationMsgOppi(),"Payable Amount = 20.516566573749998 TRY (1 TRX = 4.103313314749999 TRX)");
        //pm.enterAmount("3");
        pm.clickPayButton();

        ss.screnshot(driver);

       Thread.sleep(2000);
      // driver.switchTo().window(newwindow);
      // pm.getQrCodeCopy();

       // driver.switchTo().window(mainwindow);

    }

    @Test(groups="oppi wallet")
    public void testDepositOppiCoversionMsg() throws InterruptedException, IOException {
        // Example usage
        pm.setDepositId("123");
        pm.setDepositName("Test Deposit");
        pm.setDepositAmount("5"); //conversion depend on amount entered
        pm.selectDepositType("Deposit");
        pm.selectCurrency("6687ad11fd30994303056038");
        pm.submitForm();

        Thread.sleep(2000);

        // sw=new SwitchWindow();
        sw.switchWindow1(driver);

        Thread.sleep(4000);
        // pm.paymentModuleSelect();
        pm.selectCurrencyIframe("TRX");

        Thread.sleep(1000);

        Assert.assertEquals(pm.setValidationMsgOppi(), "Payable Amount = 20.516566573749998 TRY (1 TRX = 4.103313314749999 TRX)");

        ss.screnshot(driver);
    }

    @Test(groups="credit card")
    public void testDepositCrediCard() throws InterruptedException, IOException {
        // Example usage
        pm.setDepositId("123");
        pm.setDepositName("Test Deposit");
        pm.setDepositAmount("53");
        pm.selectDepositType("Deposit");
        pm.selectCurrency("6687ad11fd30994303056038");
        pm.submitForm();

        Thread.sleep(2000);

        //switch to new window
        sw.switchWindow1(driver);

        Thread.sleep(4000);
        pm.selectCreditCard();
        pm.enterUsername("testuser");
        pm.enterFullName("Test User");
        pm.enterCitizenship("98765432101");
        pm.enterBirthyear("1990");
        pm.enterCardNumber("4111111111111111");
        pm.enterCardHolderName("Test User");
        pm.enterExpirationDate("12/25");
        pm.enterCardCvv("123");

        pm.clickPayButton();


        ss.screnshot(driver);

        Thread.sleep(3000);

        ss.screnshot(driver);
       // driver.switchTo().window(newwindow);
       // pm.getQrCodeCopy();

        // driver.switchTo().window(mainwindow);

    }


    @Test(groups="bank transfer")
    public void DepositUsingBankTransfer() throws InterruptedException, IOException {
        // Example usage
        pm.setDepositId("123");
        pm.setDepositName("Test Deposit");
        pm.setDepositAmount("3");
        pm.selectDepositType("Deposit");
        pm.selectCurrency("6687ad11fd30994303056038");
        pm.submitForm();

        Thread.sleep(2000);

        // sw=new SwitchWindow();
        sw.switchWindow1(driver);

        Thread.sleep(7000);
        pm.setBankTransfer();
        Thread.sleep(2000);
        pm.setSelectBank();
        pm.enterBTFirstName("jay");
        pm.enterBTLastName("patel");
        ss.screnshot(driver);
        pm.clickPayButton();
        ss.screnshot(driver);
        Thread.sleep(2000);
        ss.screnshot(driver);
        Thread.sleep(3000);
        ss.screnshot(driver);

    }

    @Test(groups="bank transfer")
    public void DepositUsingBankTransferWithBlankName() throws InterruptedException, IOException {
        // Example usage
        pm.setDepositId("123");
        pm.setDepositName("Test Deposit");
        pm.setDepositAmount("3");
        pm.selectDepositType("Deposit");
        pm.selectCurrency("6687ad11fd30994303056038");
        pm.submitForm();

        Thread.sleep(2000);

        // sw=new SwitchWindow();
        sw.switchWindow1(driver);

        Thread.sleep(7000);
        pm.setBankTransfer();
        Thread.sleep(2000);
        pm.setSelectBank();
        pm.enterBTFirstName("jay");
        pm.enterBTLastName("patel");
        pm.clickPayButton();
        Thread.sleep(2000);
        ss.screnshot(driver);
    }

    @Test
    public void testWithdrawFormSubmission() throws InterruptedException {
        // Example usage
        pm.setDepositId("123");
        pm.setDepositName("Test Withdraw");
        pm.setDepositAmount("3");
        pm.selectDepositType("Withdraw");
        pm.selectCurrency("667554e3a693fe4c362c034a");
        pm.submitForm();

        // Add assertions or further actions as needed
    }

}
