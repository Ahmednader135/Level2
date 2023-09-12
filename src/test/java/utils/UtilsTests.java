package utils;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class UtilsTests extends BaseTest {

    WebDriver driver;

    public UtilsTests(WebDriver driver){
        this.driver =driver;
    }


    // screen shot

    public void takeScreenShot(String name) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("report/"+name+".png"));
    }
}
