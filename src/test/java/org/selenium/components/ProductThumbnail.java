package org.selenium.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.base.BasePageObject;
import org.selenium.pageObjects.CartPage;

public class ProductThumbnail extends BasePageObject {
    By viewCartLink = By.cssSelector("a[title='View cart']");


    public ProductThumbnail(WebDriver driver) {
        super(driver);
    }

    private By getAddToCartElement(String productName){
        return By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    }

    @Step
    public ProductThumbnail clickAddToCart(String productName){
        By addToCartBtn = getAddToCartElement(productName);
        driver.findElement(addToCartBtn).click();
        return this;
    }

    @Step
    public CartPage clickViewCart(){
        WebElement e = waitForElementToBeClickable(viewCartLink);
        e.click();
        return new CartPage(driver);
    }


}
