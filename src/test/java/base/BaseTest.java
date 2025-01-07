package base;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public Logger logger; // make sure it is from " org.apache.logging.log4j.Logger "
    public Properties properties;


    @BeforeClass
    @Parameters({"os","browser"})
    public void setUp(String os, String browser) throws IOException {
        //Loading config.properties file
        FileReader file = new FileReader("./src//test//resources//config.properties ");
        properties = new Properties();
        properties.load(file);


        logger = LogManager.getLogger(this.getClass());
        switch (browser.toLowerCase()){
            case "chrome" : driver = new ChromeDriver(); break;
            case "edge" : driver = new EdgeDriver(); break;
            case "firefox" : driver = new FirefoxDriver(); break;
            default:
                System.out.println("Invalid browser name"); return; // return te exit the execution
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty("appURL"));
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
