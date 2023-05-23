package org.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePageObject(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void loadUrl(String endpoint){
        driver.get("https://askomdch.com/" + endpoint);
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

    public WebElement waitForElementToBeClickable(By element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
