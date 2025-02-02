package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement linkMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement linkRegister;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement lnkLogin;

    public void clickMyAccountNavItem(){
        linkMyAccount.click();
    }

    public void clickRegister(){
        linkRegister.click();
    }

    public void clickLogin(){
        lnkLogin.click();
    }
}
