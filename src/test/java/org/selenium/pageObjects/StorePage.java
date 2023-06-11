package org.selenium.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.base.BasePageObject;
import org.selenium.components.HeaderComponent;
import org.selenium.components.ProductThumbnail;

public class StorePage extends BasePageObject {

    By searchField = By.cssSelector("#woocommerce-product-search-field-0");
    By searchBtn = By.cssSelector("button[value='Search']");
    By title = By.cssSelector(".woocommerce-products-header__title.page-title");

    private ProductThumbnail productThumbnail;

    @Step
    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }

    private HeaderComponent headerComponent;

    public StorePage(WebDriver driver) {
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
        headerComponent = new HeaderComponent(driver);
    }

    private StorePage enterSearchObject(String text){
        driver.findElement(searchField).sendKeys(text);
        return this;
    }

    @Step
    public StorePage loadStorePage () throws IllegalAccessException {
        loadUrl("/store");
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



}
