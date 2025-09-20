package TestCasess;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(utilities.ExtentReportManager.class)
public class TC001 extends BaseClass {
    @Test(dataProvider="LoginData",dataProviderClass = utilities.DataProviders.class )    //getting dataprovider from different class
    public void verify_loginDDT(String email,String pwd,String exp) {
        try {
            logger.info("***** Starting TC003_LoginDDT ******");
            System.out.println(email+" "+pwd+" "+exp);
            //Homepage object
            HomePage hp = new HomePage(getDriver());
            hp.clickMyAccount();
            hp.clickLogin();
            //Login Page object
            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail(email);
            lp.setPassword(pwd );
            lp.clickLogin();
            MyAccountPage myacc = new MyAccountPage(getDriver());
            String Expected_Result=exp;
            String trim_exp="";
            if(Expected_Result!=null)
            {
                trim_exp=Expected_Result.trim().toLowerCase();
            }
            if(myacc.is_txtdisplyed())
            {
                String Actual_Result = "Valid";
                myacc.logout();
                myacc.click_continue_to_logout();
                Assert.assertEquals(Actual_Result.trim().toLowerCase(),trim_exp);
            }
            else
            {
                String Actual_Result = "InValid";
                Assert.assertEquals(Actual_Result.trim().toLowerCase(),trim_exp);
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
