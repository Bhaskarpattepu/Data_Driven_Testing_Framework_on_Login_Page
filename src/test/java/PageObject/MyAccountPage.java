package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement txt_for_MyAccount;

    @FindBy(xpath = "//a[normalize-space()='My Account']")
    WebElement lnkMyAcoount;

    @FindBy(xpath = "//a[normalize-space()='Logout'][1]")
    WebElement element;

    @FindBy(xpath = "//div[@class='pull-right']//a[text()='Continue']")
    WebElement continue_logout;

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("User is in clickMy Account in after login");
        WebElement my_account = wait.until(ExpectedConditions.elementToBeClickable(lnkMyAcoount));
        Actions actions = new Actions(driver);
        actions.moveToElement(lnkMyAcoount).perform();
        System.out.println("Logout enabled? " + element.isEnabled());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void click_continue_to_logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continue_logout)).click();
    }

    public boolean is_txtdisplyed()
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            boolean bool = wait.until(ExpectedConditions.textToBePresentInElement(txt_for_MyAccount,"My Account"));
            return bool;
        }
        catch (Exception e)
        {
            return false;
        }

    }
}