package org.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.base.BasePageObject;

public class CartPage extends BasePageObject {

//    By productName = By.cssSelector("td[class='product-name'] a");
//    By checkoutBtn = By.cssSelector(".checkout-button.button.alt.wc-forward");

    @FindBy(css = "td[class='product-name'] a")
    private WebElement productName;

    @FindBy(css = ".checkout-button.button.alt.wc-forward")
    private WebElement checkoutBtn;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
//        return driver.findElement(productName).getText();
    }

    public CheckoutPage clickCheckoutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        return new CheckoutPage(driver);
    }

}
