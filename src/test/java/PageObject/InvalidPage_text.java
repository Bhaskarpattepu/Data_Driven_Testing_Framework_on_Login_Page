package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvalidPage_text extends BasePage{

    @FindBy(xpath = "//div[contains(text(),'Warning:')]")
    WebElement Warning_message;

    public String getting_warning_message()
    {
        return Warning_message.getText();
    }
    public WebElement WebElment_of_Warning_msg()
    {
        return Warning_message;
    }
}
