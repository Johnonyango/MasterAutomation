package org.selenium.base;

import io.restassured.http.Cookies;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.selenium.constants.BrowserType;
import org.selenium.factory.DriverManagerFactory;
import org.selenium.factory.abstractFactory.DriverManagerAbstract;
import org.selenium.factory.abstractFactory.DriverManagerFactoryAbstract;
import org.selenium.utils.CookieUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseClass {

//    protected WebDriver driver;
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private ThreadLocal<DriverManagerAbstract> driverManager = new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    public WebDriver getDriver(){
        return this.driver.get();
    }
    private DriverManagerAbstract getDriverManager(){
        return this.driverManager.get();
    }

    public void setDriverManager(DriverManagerAbstract driverManager) {
        this.driverManager.set(driverManager);
    }

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(@Optional String browser) throws IllegalAccessException {
        if (browser == null) browser = "CHROME";
//        setDriver(DriverManagerFactory.getDriverManager(BrowserType.valueOf(browser)).createDriver());
        setDriverManager(DriverManagerFactoryAbstract.getDriverManager(BrowserType.valueOf(browser)));
        setDriver(getDriverManager().getDriver());
        System.out.println("Current Thread: "+Thread.currentThread().getId() + ", "+ "Driver = "+ getDriver());
    }



    @AfterMethod
    public void quitDriver(ITestResult testResult, @Optional String browser) throws InterruptedException, IOException {
        Thread.sleep(5000);
        System.out.println("Current Thread: "+Thread.currentThread().getId() + ", "+ "Driver = "+ getDriver());

        if (testResult.getStatus()==ITestResult.FAILURE){
            File destFile = new File("src" + File.separator + browser
                    + File.separator + testResult.getTestClass().getRealClass().getSimpleName()
                    + "_" + testResult.getMethod().getMethodName() + ".png");
            takeScreenshotUsingItest(destFile);
//            takeScreenshotUsingAshot(destFile);

        }

        getDriver().quit();
//        driver.quit();
    }

    public void injectCookiesToBrowser(Cookies restAssuredCookies){
        List<Cookie> seleniumCookies = new CookieUtil().convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for (Cookie cookie : seleniumCookies){
            getDriver().manage().addCookie(cookie);
        }
    }

    private void takeScreenshotUsingItest(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }
    private void takeScreenshotUsingAshot(File destFile){
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(getDriver());

        try {
            ImageIO.write(screenshot.getImage(), "PNG", destFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
