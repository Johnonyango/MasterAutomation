package org.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.base.BasePageObject;

public class StorePage extends BasePageObject {

    By searchField = By.cssSelector("#woocommerce-product-search-field-0");
    By searchBtn = By.cssSelector("button[value='Search']");
    By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    private By getAddToCartElement(String productName){
        return By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    }
    private StorePage enterSearchObject(String text){
        driver.findElement(searchField).sendKeys(text);
        return this;
    }

    private StorePage clickSearchButton(){
        WebElement e = waitForElementToBeClickable(searchBtn);
        e.click();
        return this;
    }

    public StorePage searchObject(){
        enterSearchObject("Blue").clickSearchButton();
        return this;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    public StorePage clickAddToCart(String productName){
         By addToCartBtn = getAddToCartElement(productName);
         driver.findElement(addToCartBtn).click();
         return this;
    }

    public CartPage clickViewCart(){
        WebElement e = waitForElementToBeClickable(viewCartLink);
        e.click();
        return new CartPage(driver);
    }


}
