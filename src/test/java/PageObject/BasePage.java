package PageObject;

import TestBase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage {
    WebDriver driver;
    public BasePage(/* WebDriver driver */)
    {
        this.driver= BaseClass.getDriver();
        PageFactory.initElements(driver,this);
    }
}
