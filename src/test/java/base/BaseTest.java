package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import utils.ScreenRecorderUtil;
import utils.UtilsTests;
public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;
    protected ReadDataFromJson readDataFromJson;
    UtilsTests utilsTests;
    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws FileNotFoundException {
        setupBrowser(browser);
        driver.manage().window().maximize();
        homePage=new HomePage(driver);
        //gohome();
    }
    @Parameters("browser")
    private void setupBrowser(String browser)
    {
        if(browser.equalsIgnoreCase("chrome") )
        {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("headlessChrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver = new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("firefox") )
        {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("headlessFirefox"))
        {
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            driver = new FirefoxDriver();
        }
        if(browser.equalsIgnoreCase("edge") )
        {
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("headlessFirefox"))
        {
            EdgeOptions options = new EdgeOptions();
            options.setHeadless(true);
            driver = new EdgeDriver();
        }
    }

    @BeforeMethod
    public void goHome(Method method) throws Exception {
        readDataFromJson = new ReadDataFromJson();
        driver.get(readDataFromJson.readJsonFile().URL);
        ScreenRecorderUtil.startRecord(method.getName());
    }

    @AfterMethod
    public void setStatus(Method method) throws Exception {
        utilsTests = new UtilsTests(driver);
        ScreenRecorderUtil.stopRecord();
        utilsTests.takeScreenShot(method.getName());

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
