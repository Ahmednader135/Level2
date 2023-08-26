package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class LoginTest extends BaseTest {
    

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException {
        readDataFromJson=new ReadDataFromJson();
        LoginPage loginPage =homePage.clickOnLoginLink();
        loginPage.sendUserName(readDataFromJson.readJsonFile().Login.ValidCredentials.UserName);
        loginPage.sendPassword(readDataFromJson.readJsonFile().Login.ValidCredentials.Password);
        loginPage.clickOnLoginButton();
    }

}
