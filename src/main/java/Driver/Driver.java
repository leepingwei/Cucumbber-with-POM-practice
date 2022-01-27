package Driver;

import POM.Base;
import Util.CustomEventListener;
import Util.ProgramNotSupportBrowserException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            String browserName = Base.properties.getProperty("browser");
            if(browserName.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }else if(browserName.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }else{
                // Using customized Exception for if user passing other browsers
                throw new ProgramNotSupportBrowserException("This program not support your browser");
            }
        }
        // Wrapping the CustomEventListener to the driver
        EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
        CustomEventListener eventListener = new CustomEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
