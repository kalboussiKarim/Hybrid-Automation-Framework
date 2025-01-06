package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import java.time.Duration;


public class TC001AccountRegistrationTest {

    WebDriver driver;


    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://localhost/opencart-4.0.2.3/upload/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


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

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public String randomString(int num){
        return RandomStringUtils.randomAlphabetic(num);
    }

    public String randomNumber(int num){
        return RandomStringUtils.randomNumeric(num);
    }
}
