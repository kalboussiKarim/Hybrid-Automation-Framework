package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath= "//input[@id='input-email']")
    WebElement txtEmailInput;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPasswordInput;

    @FindBy(xpath ="//button[normalize-space()='Login']")
    WebElement btnLogin;

    public void setTxtEmail(String email){
        txtEmailInput.sendKeys(email);
    }

    public void setTxtPassword(String password){
        txtPasswordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        btnLogin.submit();
    }


}
