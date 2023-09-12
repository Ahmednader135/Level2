package login;

import base.BaseTest;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import reader.ReadDataDrivenFromJson;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

   ReadDataDrivenFromJson readDataDrivenFromJson;


   /* @Test
    public void testSuccessfulLogin() throws FileNotFoundException {
        readDataFromJson=new ReadDataFromJson();
        LoginPage loginPage =homePage.clickOnLoginLink();
        loginPage.sendUserName(readDataFromJson.readJsonFile().Login.ValidCredentials.UserName);
        loginPage.sendPassword(readDataFromJson.readJsonFile().Login.ValidCredentials.Password);
        loginPage.clickOnLoginButton();
    }
*/
    @DataProvider
    public Object[] testDataForSuccessfulLogin() throws IOException, ParseException {
        readDataDrivenFromJson = new ReadDataDrivenFromJson();
        return readDataDrivenFromJson.readDataForSuccessfulLogin();
    }
    @Test(dataProvider = "testDataForSuccessfulLogin")
    public void testSuccessfulLogin(String data) throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        String[] Users = data.split(",");
        LoginPage loginPage =homePage.clickOnLoginLink();
        loginPage.sendUserName(Users[0]);
        loginPage.sendPassword(Users[1]);
        loginPage.clickOnLoginButton();
        String actualResult = loginPage.getValidationMessage();
        String expectedResult = readDataFromJson.readJsonFile().ExpectedResult;
        assertTrue(actualResult.contains(expectedResult));
    }

}



