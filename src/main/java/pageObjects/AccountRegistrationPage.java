package pageObjects;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstnameInput;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastnameInput;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmailInput;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPasswordInput;

    @FindBy(xpath = "//input[@id='input-newsletter']")
    WebElement chkdNewsletter;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkdPrivacyPolicy;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement btnRegister;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;


    public void setTxtFirstname(String firstname){
        txtFirstnameInput.sendKeys(firstname);
    }

    public void setTxtLastname(String lastname){
        txtLastnameInput.sendKeys(lastname);
    }

    public void setTxtEmail(String email){
        txtEmailInput.sendKeys(email);
    }

    public void setTxtPassword(String password){
        txtPasswordInput.sendKeys(password);
    }

    public void checkNewsletter(){
        chkdNewsletter.click();
    }

    public void checkPrivacyPolicy(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chkdPrivacyPolicy);
    }

    public void clickRegisterButton(){
        btnRegister.submit();
    }

    public String getMsgConfirmation(){
        try {
            return msgConfirmation.getText();
        }catch (Exception e){
            return e.getMessage();
        }
    }

}
