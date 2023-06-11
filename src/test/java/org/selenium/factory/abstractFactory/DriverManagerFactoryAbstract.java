package org.selenium.factory.abstractFactory;

import org.selenium.constants.BrowserType;
import org.selenium.factory.ChromeDriverManager;
import org.selenium.factory.DriverManager;
import org.selenium.factory.FirefoxDriverManager;

public class DriverManagerFactoryAbstract {
    public static DriverManagerAbstract getDriverManager(BrowserType browserType){
        switch (browserType){
            case CHROME:
                return new ChromeDriverManagerAbstract();
            case FIREFOX:
                return new FirefoxDriverManagerAbstract();
            default:
                throw new IllegalStateException("Unexpected Value " + browserType);
        }
    }
}
