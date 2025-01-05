package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private final By myAccountNavItem = By.xpath("//span[normalize-space()='My Account']");
    private final By registerChoiceAccountNavItem = By.xpath("//a[normalize-space()='Register']");

    public void clickMyAccountNavItem(){
        find(myAccountNavItem).click();
    }

    public void clickRegister(){
        find(registerChoiceAccountNavItem).click();
    }




}
