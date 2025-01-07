package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003AccountLoginDDT extends BaseTest {

    @Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups={"DataDriven"})
    public void test_account_login_DDT(String email, String password, String expectedResult ){

        boolean isHeaderDisplayed;
        logger.info("******** Starting TC003AccountLoginTest DDT ********");
        try {

            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccountNavItem();
            homePage.clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setTxtEmail(email);
            loginPage.setTxtPassword(password);
            loginPage.clickLoginButton();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            try {
                isHeaderDisplayed = myAccountPage.isAccountHeaderDisplayed();
            }catch (Exception e){
                isHeaderDisplayed = false;
            }

            if(isHeaderDisplayed) {
                if (expectedResult.equalsIgnoreCase("Valid")) {
                    myAccountPage.clickLogoutLink();
                    Assert.assertTrue(true);
                } else {
                    myAccountPage.clickLogoutLink();
                    Assert.fail();
                }
            }else {
                System.out.println(expectedResult);
                if (expectedResult.equalsIgnoreCase("Not valid")) {
                    Assert.assertTrue(true);
                }else {
                    Assert.fail();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
        logger.info("******** Finished TC002AccountLoginTest DDT ********");

    }
}
