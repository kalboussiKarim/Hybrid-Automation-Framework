package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;


public class TC001AccountRegistrationTest extends BaseTest {

    @Test
    public void test_account_registration(){

        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccountNavItem();
        homePage.clickRegister();
        String firstname = randomString(5);
        String lastname = randomString(5);
        AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
        accountRegistrationPage.setTxtFirstname(firstname);
        accountRegistrationPage.setTxtLastname(lastname);
        accountRegistrationPage.setTxtEmail(firstname+"."+lastname+"@gmail.com");
        accountRegistrationPage.setTxtPassword(firstname);
        accountRegistrationPage.checkPrivacyPolicy();
        accountRegistrationPage.clickRegisterButton();
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = accountRegistrationPage.getMsgConfirmation();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
