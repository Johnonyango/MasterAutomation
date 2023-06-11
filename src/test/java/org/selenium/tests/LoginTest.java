package org.selenium.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.selenium.api.actions.CartApi;
import org.selenium.api.actions.SignUpApi;
import org.selenium.base.BaseClass;
import org.selenium.objects.Product;
import org.selenium.objects.User;
import org.selenium.pageObjects.CheckoutPage;
import org.selenium.utils.FakerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseClass {

    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("1234567")
    @TmsLink("1234")
    @Description("Description of Login Test")
    @Test(description = "Test that the user can login")
    public void loginDuringCheckout() throws IllegalAccessException, IOException, InterruptedException {

        String username = "demouser" + new FakerUtil().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demouser").
                setEmail(username + "@example.com");
        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);

        CartApi cartApi = new CartApi();
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        Thread.sleep(5000);
        injectCookiesToBrowser(cartApi.getCookies());
        checkoutPage.load();
        Thread.sleep(5000);
        checkoutPage.showLogin().
                login(user);
        Thread.sleep(5000);
        Assert.assertTrue(checkoutPage.getCheckoutProductName().contains(product.getName()));
    }

}
