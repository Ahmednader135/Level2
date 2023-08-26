package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class BaseTest {

    public WebDriver driver;//new
    public HomePage homePage;
    public ReadDataFromJson readDataFromJson;
    @BeforeClass
    public void Setup() throws FileNotFoundException {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        homePage=new HomePage(driver);
        gohome();
    }

    @BeforeMethod
    public void gohome() throws FileNotFoundException {
        readDataFromJson=new ReadDataFromJson();
        driver.get(readDataFromJson.readJsonFile().URL);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
