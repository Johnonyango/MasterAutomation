package org.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.base.BasePageObject;

public class HomePage extends BasePageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        loadUrl("/");
        return this;
    }
    private By storeLink = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");

    public StorePage clickStoreObject(){
        WebElement e = waitForElementToBeClickable(storeLink);
        e.click();
        return new StorePage(driver);
    }
}
