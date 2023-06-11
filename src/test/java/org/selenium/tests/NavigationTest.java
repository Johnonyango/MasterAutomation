package org.selenium.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.selenium.base.BaseClass;
import org.selenium.pageObjects.HomePage;
import org.selenium.pageObjects.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseClass {

    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("1234567")
    @TmsLink("1234")
    @Description("Description for Navigation Test")
    @Test(description = "Test that the user can search for product")
    public void navigateFromHomeToStoreUsingMainMenu() throws IllegalAccessException {
        StorePage storePage = new HomePage(getDriver()).
                load().getHeaderComponent().clickStoreObject();
        Assert.assertEquals(storePage.getTitle(), "Store");
    }
}
