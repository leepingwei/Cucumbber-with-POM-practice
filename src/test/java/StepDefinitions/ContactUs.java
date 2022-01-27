package StepDefinitions;

import Driver.Driver;
import POM.Base;
import POM.ContactUsPage;
import POM.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ContactUs {

    HomePage homePage = new HomePage();
    ContactUsPage contactUsPage = new ContactUsPage();

    @Given("Navigate to shopdemo website")
    public void navigate_to_shopdemo_website() {
        WebDriver driver = Driver.getDriver();

        long timeForPageLoad = Long.parseLong(Base.properties.getProperty("setPageLoadTimeOut"));
        long timeForImplicitlyWait = Long.parseLong(Base.properties.getProperty("setImplicitlyWait"));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(timeForPageLoad, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(timeForImplicitlyWait, TimeUnit.SECONDS);

        driver.get(Base.properties.getProperty("url"));
        driver.manage().window().maximize();
    }
    @When("User click on contact us link")
    public void user_click_on_contact_us_link() {
        homePage.chooseAnElementAndClick("contactUsLink");
    }

    @Then("User fill up the form and submit with {string} {string} {string} {string}")
    public void userFillUpTheFormAndSubmitWith(String Name, String Email, String Subject, String Message) {
        contactUsPage.chooseAnElementAndSendKeys("name", Name);
        contactUsPage.chooseAnElementAndSendKeys("email", Email);
        contactUsPage.chooseAnElementAndSendKeys("subject", Subject);
        contactUsPage.chooseAnElementAndSendKeys("message", Message);
    }

    @Then("User quit the browser")
    public void user_quit_the_browser() {
        contactUsPage.quitFromBrowser();
    }
}
