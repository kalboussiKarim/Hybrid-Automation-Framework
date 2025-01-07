package testCases;

import base.BaseTest;
import com.google.j2objc.annotations.Property;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002AccountLoginTest extends BaseTest {

    @Test(groups={"Sanity","Master"})
    public void test_account_login(){

        try {
            logger.info("******** Starting TC002AccountLoginTest ********");
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccountNavItem();
            //logger.info("Clicked on MyAccount Link");
            homePage.clickLogin();
            //logger.info("Clicked on Login Link");

            LoginPage loginPage = new LoginPage(driver);
            //logger.info("Providing email and password...");
            loginPage.setTxtEmail(properties.getProperty("email"));
            loginPage.setTxtPassword(properties.getProperty("password"));
            loginPage.clickLoginButton();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean isHeaderDisplayed = myAccountPage.isAccountHeaderDisplayed();
            Assert.assertTrue(isHeaderDisplayed,"Login Failed.");

        }catch (Exception e){
            Assert.fail();
        }
        logger.info("******** Finished TC002AccountLoginTest ********");

    }
}
