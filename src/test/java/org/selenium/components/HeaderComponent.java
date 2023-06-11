package org.selenium.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.base.BasePageObject;
import org.selenium.pageObjects.CartPage;
import org.selenium.pageObjects.StorePage;

public class HeaderComponent extends BasePageObject {
    private By viewCartLink = By.cssSelector("a[title='View cart']");
    private By storeLink = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");


    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public CartPage clickViewCart(){
        WebElement e = waitForElementToBeClickable(viewCartLink);
        e.click();
        return new CartPage(driver);
    }

    @Step
    public StorePage clickStoreObject(){
        WebElement e = waitForElementToBeClickable(storeLink);
        e.click();
        return new StorePage(driver);
    }
}
