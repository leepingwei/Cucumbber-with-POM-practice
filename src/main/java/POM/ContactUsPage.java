package POM;

import Driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends Base {

    public ContactUsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "sender_name")
    private WebElement name;

    @FindBy(id = "sender_email")
    private WebElement email;

    @FindBy(id = "sender_subject")
    private WebElement subject;

    @FindBy(id = "sender_message")
    private WebElement message;

    WebElement element;

    public void chooseAnElementAndSendKeys(String elementName, String value){
        switch(elementName){
            case "name":
                element = name;
                break;
            case "email":
                element = email;
                break;
            case "subject":
                element = subject;
                break;
            case "message":
                element = message;
        }
        sendKeysFunction(element, value);
    }
}
