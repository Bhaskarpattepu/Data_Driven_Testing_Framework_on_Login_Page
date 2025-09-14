package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    /*
        public MyAccountPage(WebDriver driver)
        {
            super(driver);
        }
    */

    @FindBy(xpath = "//div[@id='content']//h2[normalize-space()='My Account']")
    WebElement msgHeading;

    @FindBy(xpath = "//a[normalize-space()='My Account']")
    WebElement lnkMyAcoount;

    @FindBy(xpath = "//a[normalize-space()='Logout'][1]")
    WebElement logout;

    @FindBy(xpath = "//div[@class='pull-right']//a[text()='Continue']")
    WebElement continue_logout;

    public String isMyAccountPageExist()
    {
       return msgHeading.getText();
    }


    public void clickMyAccount() {lnkMyAcoount.click();}
    public void click_logout() {logout.click();}
    public void click_continue_to_logout() {continue_logout.click();}
    public WebElement WebElement_of_MyAccount_txt(){ return msgHeading; }
    public WebElement WebElement_of_My_Account(){ return lnkMyAcoount; }


}