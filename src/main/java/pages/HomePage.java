package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethdHandles;

public class HomePage extends MethdHandles {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By loginLink =By.cssSelector(".ico-login");

    public LoginPage clickOnLoginLink(){
        click(loginLink);
      return new LoginPage(driver);
    }
}
