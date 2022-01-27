package StepDefinitions;

import POM.HomePage;
import io.cucumber.java.en.*;

public class ShareToFacebook {

    HomePage homePage = new HomePage();

    @When("User click on Share button")
    public void user_click_on_share_button() {
        homePage.chooseAnFrameAndSwitchTo("shareButtonFrame");
        homePage.chooseAnElementAndClick("shareToFacebookButton");
        homePage.switchToWindowFunction();
    }

    @Then("Verify Login message on the pop up window")
    public void verify_login_message_on_the_pop_up_window() {
        homePage.chooseAnElementAndVerifyText("faceBookText", "facebook");
    }
}
