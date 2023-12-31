package org.selenium.factory.abstractFactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManagerAbstract {

    public WebDriver driver;
    protected abstract void startDriver();

    public void quitDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }

    public WebDriver getDriver(){
        if (driver==null){
            startDriver();
        }
        return driver;
    }
}
