package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class screenShot {

    public void screnshot(WebDriver driver) throws IOException {
        TakesScreenshot ss=(TakesScreenshot) driver;
        File srcFile=ss.getScreenshotAs(OutputType.FILE);
        String time= new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
        File destFile=new File("./ss/"+time+".png");
        FileUtils.copyFile(srcFile, destFile);
    }
}
