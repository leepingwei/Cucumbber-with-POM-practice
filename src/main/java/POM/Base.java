package POM;

import Driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Base {

    public static Properties properties;
    WebDriver driver;
    WebDriverWait wait;

    public Base(){

        // Initialize Properties for reading config.properties file
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("/Users/lipingwei/IdeaProjects/ProjectShopDemoEJunkie/src/main/java/Util/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = Driver.getDriver();

        long timeForExplicitlyWait = Long.parseLong(properties.getProperty("setExplicitlyWait"));
        wait = new WebDriverWait(driver, timeForExplicitlyWait);
    }

    public void scrollToAnElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    public void clickFunction(WebElement element){
        scrollToAnElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        //element.click();
    }

    public void sendKeysFunction(WebElement element, String value){
        scrollToAnElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public void verifyTextFunction(WebElement element, String expectedText){
        scrollToAnElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().contains(expectedText));
    }

    public void switchToWindowFunction(){
        Set<String> windowId = driver.getWindowHandles();
        for(String id : windowId){
            driver.switchTo().window(id);
        }
    }

    public void switchToFrameFunction(WebElement element){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void verifyElementDisplayed(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
    }

    public void quitFromBrowser(){
        Driver.quitDriver();
    }
}
