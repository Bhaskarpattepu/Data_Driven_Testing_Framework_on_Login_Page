package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEmailAdress;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    public void setEmail(String email)
    {
        if(email != null)
        {
            System.out.println("Enter email");
            txtEmailAdress.clear();
            txtEmailAdress.sendKeys(email);
        }

    }
    public void setPassword(String pwd)
    {
        if(pwd != null)
        {
            System.out.println("Enter Password");
            txtPassword.clear();
            txtPassword.sendKeys(pwd);
        }
    }
    public void clickLogin()
    {
        System.out.println("Click Login after user enters login cred");
        btnLogin.click();
    }
}
