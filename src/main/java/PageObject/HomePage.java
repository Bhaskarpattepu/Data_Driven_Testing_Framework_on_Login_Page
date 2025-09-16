package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='My Account']")
    WebElement lnkMyAcoount;

    @FindBy(linkText = "Login")
    WebElement linkLogin;

    public void clickMyAccount()
    {
        System.out.println("Clickmyaccount_in_home");
        lnkMyAcoount.click();
    }
    public void clickLogin(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Login_button = wait.until(ExpectedConditions.elementToBeClickable(linkLogin));
        Login_button.click();

        System.out.println("click_login_in_home");
        linkLogin.click();

    }

}

