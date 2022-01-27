package POM;

import Driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[class='contact']")
    private WebElement contactUsLink;

    @FindBy(css = "iframe[allow='encrypted-media']")
    private WebElement shareButtonFrame;

    @FindBy(css = "a[class='_2vmz'] button")
    private WebElement shareToFacebookButton;

    @FindBy(id = "content")
    private WebElement faceBookText;

    @FindBy(xpath = "//div[@class = 'columns products is-multiline']//button[@class='view_product']")
    private WebElement productItem;

    @FindBy(css = "iframe[class='EJIframeV3 EJOverlayV3']")
    private WebElement proceedToPayFrame;

    @FindBy(css = "button[class = 'Continue-Button Close-Cart']")
    private WebElement continueShoppingButton;

    @FindBy(css = "div[class = 'share']+a")
    private WebElement shoppingCartLink;

    @FindBy(css = "div[class = 'Col2 Product-Desc']")
    private WebElement itemInShoppingCart;

    WebElement element;

    public void chooseAnElementAndClick(String elementName){
        switch(elementName){
            case "contactUsLink":
                element = contactUsLink;
                break;
            case "shareToFacebookButton":
                element = shareToFacebookButton;
                break;
            case "productItem":
                element = productItem;
                break;
            case "continueShoppingButton":
                element = continueShoppingButton;
                break;
            case "shoppingCartLink":
                element = shoppingCartLink;
        }
        clickFunction(element);
    }

    public void chooseAnElementAndVerifyText(String elementName, String expectedText){
        switch(elementName){
            case "faceBookText":
                element = faceBookText;
        }
        verifyTextFunction(element, expectedText);
    }

    public void chooseAnFrameAndSwitchTo(String elementName){
        switch (elementName){
            case "shareButtonFrame":
                element = shareButtonFrame;
                break;
            case "proceedToPayFrame":
                element = proceedToPayFrame;
        }
        switchToFrameFunction(element);
    }

    public void chooseAnElementAndCheckDisplayed(String elementName){
        switch (elementName){
            case "itemInShoppingCart":
                element = itemInShoppingCart;
        }
        verifyElementDisplayed(element);
    }

}
