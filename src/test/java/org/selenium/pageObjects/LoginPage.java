package org.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.base.BasePageObject;
import org.selenium.objects.User;

public class LoginPage extends BasePageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "user.username")
    private WebElement myUserName;
    @FindBy(name = "user.password")
    private WebElement myPassword;
    @FindBy(xpath = "//span[text()=\"Login\"]")
    private WebElement myloginButton;

    private LoginPage enterUsername(String uname){
        WebElement e = waitForElementVisibilityE(myUserName);
        e.clear();
        e.sendKeys(uname);
        return  this;
    }
    private LoginPage enterPassword(String pwd){
        WebElement e = waitForElementVisibilityE(myPassword);
        e.clear();
        e.sendKeys(pwd);
        return  this;
    }
    public LoginPage clickLogin(){
        WebElement e = waitForElementToBeClickableE(myloginButton);
        e.click();
        return this;
    }

    public LoginPage login(User user){
        return enterUsername(user.getUsername()).enterPassword(user.getPassword()).clickLogin();
    }

}
