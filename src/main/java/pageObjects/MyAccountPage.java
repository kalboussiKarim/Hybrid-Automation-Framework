package pageObjects;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement headerAccount;


    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
    WebElement linkLogout;

    public boolean isAccountHeaderDisplayed(){
        return headerAccount.isDisplayed();
    }

    public void clickLogoutLink(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", linkLogout);
    }
}
