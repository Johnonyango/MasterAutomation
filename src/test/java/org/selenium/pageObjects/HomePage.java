package org.selenium.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.base.BasePageObject;
import org.selenium.components.HeaderComponent;
import org.selenium.components.ProductThumbnail;

public class HomePage extends BasePageObject {
    private ProductThumbnail productThumbnail;
    private HeaderComponent headerComponent;

    public HomePage(WebDriver driver) {
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
        headerComponent = new HeaderComponent(driver);
    }

    @Step
    public HomePage load() throws IllegalAccessException {
        loadUrl("/");
        return this;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    @Step
    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }
    

}
