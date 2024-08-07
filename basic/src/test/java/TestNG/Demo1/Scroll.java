package TestNG.Demo1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

    public static void main(String[] arg) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://crm.elaunchinfotech.in/");

        JavascriptExecutor js=(JavascriptExecutor) driver;

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,1000)");

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-500)");

        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


    }
}
