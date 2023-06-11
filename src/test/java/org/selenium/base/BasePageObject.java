package org.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.utils.ConfigLoader;

import java.time.Duration;
import java.util.List;

public class BasePageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePageObject(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    public void loadUrl(String endpoint) throws IllegalAccessException {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endpoint);
    }

    public void waitForOverlayToDisappear(By overlay){
        List<WebElement>overlays=driver.findElements(overlay);
        System.out.println("Number of overlays = " + overlays.size());
        if (overlays.size() > 0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("Overlays invisible");
        }else
            System.out.println("Overlay Not found");
    }

    public WebElement waitForElementVisibility(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public WebElement waitForElementVisibilityE(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(By element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeClickableE(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void urlIsLoaded(String url){
        wait.until(ExpectedConditions.urlContains("http://3.127.88.99:8081/Xe/"));
    }
}
