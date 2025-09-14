package TestCases;


import PageObject.HomePage;
import PageObject.InvalidPage_text;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;
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
            //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //Homepage
            HomePage hp = new HomePage();
            hp.clickMyAccount();
            hp.clickLogin();
            //Login Page
            LoginPage lp = new LoginPage();

            lp.setEmail(email);
            lp.setPassword(pwd );
            lp.clickLogin();
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String tittle = getDriver().getTitle();
            String Expted_Res =exp.trim();
            if(tittle.trim().equalsIgnoreCase("My Account"))
            {
                getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                String actualRes="Valid";
                MyAccountPage myacc = new MyAccountPage();
                myacc.clickMyAccount();
                myacc.click_logout();
                myacc.click_continue_to_logout();
                Assert.assertEquals(actualRes.trim().toLowerCase(),Expted_Res.trim().toLowerCase());
            }
            else {
                String actualRes="InValid";
                Assert.assertEquals(actualRes.trim().toLowerCase(),Expted_Res.trim().toLowerCase());
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
