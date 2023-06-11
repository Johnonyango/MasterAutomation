package org.selenium.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.constants.BrowserType;

public class DriverManagerOriginal {
    private  WebDriver driver;

    public WebDriver initializeDriver() throws IllegalAccessException {
        String browser = System.getProperty("browser", "CHROME");

        switch (BrowserType.valueOf(browser)){
            case CHROME:
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
                driver = new ChromeDriver(chromeOptions);
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver=new FirefoxDriver();
                break;
            default:
                System.out.println("invalid browser name");
                throw new IllegalAccessException("Invalid browser");

        }
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
