package base;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://localhost/opencart-4.0.2.3/upload/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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

    public String randomAlphaNumeric(){
        return RandomStringUtils.randomAlphabetic(3)+RandomStringUtils.randomNumeric(3);
    }
}
