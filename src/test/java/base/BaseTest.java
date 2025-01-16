package base;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public Logger logger; // make sure it is from " org.apache.logging.log4j.Logger "
    public Properties properties;


    @BeforeClass(groups={"Sanity","Regression","Master"})
    @Parameters({"os","browser"})
    public void setUp(String os, String browser) throws IOException, URISyntaxException {
        //Loading config.properties file
        FileReader file = new FileReader("./src//test//resources//config.properties ");
        properties = new Properties();
        properties.load(file);


        logger = LogManager.getLogger(this.getClass());

        if(properties.getProperty("execution_env").equalsIgnoreCase("remote")){
            DesiredCapabilities capabilities = new DesiredCapabilities();

            if(os.equalsIgnoreCase("windows")){
                capabilities.setPlatform(Platform.WIN10);

            }else if (os.equalsIgnoreCase("linux")) {
                capabilities.setPlatform(Platform.LINUX);

            }else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);

            }else {
                System.out.println("No matching OS");
                return;
            }

            switch (browser.toLowerCase()){
                case "chrome" : capabilities.setBrowserName("chrome"); break;
                case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
                case "firefox" : capabilities.setBrowserName("firefox"); break;
                default:
                    System.out.println("Invalid browser name"); return; // return te exit the execution
            }
            driver = new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(),capabilities);

        }else if (properties.getProperty("execution_env").equalsIgnoreCase("local")){
            switch (browser.toLowerCase()){
                case "chrome" : driver = new ChromeDriver(); break;
                case "edge" : driver = new EdgeDriver(); break;
                case "firefox" : driver = new FirefoxDriver(); break;
                default:
                    System.out.println("Invalid browser name"); return; // return te exit the execution
            }
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty("appURL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    @AfterClass(groups={"Sanity","Regression","Master"})
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

    public String captureScreen(String name){
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp+".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);
        return targetFilePath;

    }
}
