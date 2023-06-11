package org.selenium.factory;

import org.selenium.constants.BrowserType;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(BrowserType browserType){
        switch (browserType){
            case CHROME:
                return new ChromeDriverManager();
            case FIREFOX:
                return new FirefoxDriverManager();
            default:
                throw new IllegalStateException("Unexpected Value " + browserType);
        }
    }
}
