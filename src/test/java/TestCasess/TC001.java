package TestCasess;


import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(utilities.ExtentReportManager.class)
public class TC001 extends BaseClass {
    @Test(dataProvider="LoginData",dataProviderClass = utilities.DataProviders.class )    //getting dataprovider from different class
    public void verify_loginDDT(String email,String pwd,String exp) {
        try {
            logger.info("***** Starting TC003_LoginDDT ******");
            System.out.println(email+" "+pwd+" "+exp);
            //Homepage
            HomePage hp = new HomePage();
            hp.clickMyAccount();
            hp.clickLogin();
            //Login Page
            LoginPage lp = new LoginPage();

            lp.setEmail(email);
            lp.setPassword(pwd );
            lp.clickLogin();
            MyAccountPage myacc = new MyAccountPage();
            String Expected_Result=exp;
            if(myacc.is_txtdisplyed())
            {
                String Actual_Result = "Valid";
                myacc.logout();
                myacc.click_continue_to_logout();
                Assert.assertEquals(Actual_Result.trim().toLowerCase(),Expected_Result.trim().toLowerCase());
            }
            else
            {
                String Actual_Result = "InValid";
                Assert.assertEquals(Actual_Result.trim().toLowerCase(),Expected_Result.trim().toLowerCase());
            }

            logger.info("****** Finished TC003_LoginDDT ******");
        }
        catch (Exception e)
        {
            // Only unexpected issues (locator changes, infra problems) will land here
            logger.error(e.toString());
            Assert.fail("The testcase is failed due to"+e.toString());
        }
    }
}
