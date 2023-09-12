package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethdHandles;

public class LoginPage extends MethdHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");

    private By validation = By.cssSelector(".message-error.validation-summary-errors");

    public void sendUserName(String username)
    {
        sendKeys(emailField, username);
    }

    public void sendPassword(String password)
    {
        sendKeys(passwordField, password);
    }

    public void clickOnLoginButton()
    {
       click(loginButton);
    }

    public String getValidationMessage() {
        return getText(validation);
    }
}
