package org.selenium.base;

import org.openqa.selenium.WebDriver;
import org.selenium.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    protected WebDriver driver;


    @BeforeMethod
    public void startDriver() throws IllegalAccessException {
        driver = new DriverManager().initializeDriver();
    }



    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
