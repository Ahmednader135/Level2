package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethdHandles {

   protected WebDriver driver;
   WebDriverWait wait;
   public MethdHandles(WebDriver driver){
       this.driver=driver;
   }
   protected void click(By locator){
       wait =new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(driver.findElement(locator)),
               ExpectedConditions.elementToBeClickable(locator),
               ExpectedConditions.presenceOfElementLocated(locator)));
       driver.findElement(locator).click();
   }
    protected void sendKeys(By locator , String text){
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(driver.findElement(locator)),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)));
        driver.findElement(locator).sendKeys(text);
    }
    protected String getText(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(driver.findElement(locator)),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)));
        return driver.findElement(locator).getText();
    }
}
