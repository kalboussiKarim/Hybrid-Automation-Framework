package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;


public class TC001AccountRegistrationTest extends BaseTest {

    @Test(groups={"Regression","master"})
    public void test_account_registration(){

        try {
            logger.info("******** Starting TC001AccountRegistrationTest ********");
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccountNavItem();
            logger.info("Clicked on MyAccount Link");
            homePage.clickRegister();
            logger.info("Clicked on Register Link");
            String firstname = randomString(5);
            String lastname = randomString(5);
            AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
            logger.info("Providing customer details...");
            accountRegistrationPage.setTxtFirstname(firstname);
            accountRegistrationPage.setTxtLastname(lastname);
            accountRegistrationPage.setTxtEmail(firstname+"."+lastname+"@gmail.com");
            accountRegistrationPage.setTxtPassword(firstname);
            accountRegistrationPage.checkPrivacyPolicy();
            accountRegistrationPage.clickRegisterButton();
            String expectedMessage = "Your Account Has Been Created!";
            String actualMessage = accountRegistrationPage.getMsgConfirmation();
            logger.info("Validating expected message...");
            Assert.assertEquals(expectedMessage,actualMessage);
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("******** Finished TC001AccountRegistrationTest ********");

    }

}
