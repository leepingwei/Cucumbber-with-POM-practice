package StepDefinitions;

import POM.HomePage;
import io.cucumber.java.en.*;

public class AddProductToShoppingCart {

    HomePage homePage = new HomePage();

    @When("User add one product to shopping cart")
    public void user_add_one_product_to_shopping_cart() {
        homePage.chooseAnElementAndClick("productItem");
    }
    @Then("User click on continue shopping button")
    public void user_click_on_continue_shopping_button() {
        homePage.chooseAnFrameAndSwitchTo("proceedToPayFrame");
        homePage.chooseAnElementAndClick("continueShoppingButton");
    }
    @Then("User click on shopping cart link")
    public void user_click_on_shopping_cart_link() {
        homePage.chooseAnElementAndClick("shoppingCartLink");
    }
    @Then("Verify if the item been displayed")
    public void verify_if_the_item_been_displayed() {
        homePage.chooseAnFrameAndSwitchTo("proceedToPayFrame");
        homePage.chooseAnElementAndCheckDisplayed("itemInShoppingCart");
    }
}
