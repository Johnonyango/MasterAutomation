package org.selenium.tests;

import org.selenium.api.actions.CartApi;
import org.selenium.api.actions.SignUpApi;
import org.selenium.base.BaseClass;
import org.selenium.objects.BillingAddress;
import org.selenium.objects.Product;
import org.selenium.objects.User;
import org.selenium.pageObjects.CheckoutPage;
import org.selenium.utils.ConfigLoader;
import org.selenium.utils.FakerUtil;
import org.selenium.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutTest extends BaseClass {
    BillingAddress billingAddress = JacksonUtils.deserialization("billingAddress.json", BillingAddress.class);

    public CheckoutTest() throws IOException {
    }


    @Test
    public void checkoutUsingDirectBankTransfer() throws IllegalAccessException {


        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        CartApi cartApi = new CartApi();
        cartApi.addToCart(1215, 1);
        injectCookiesToBrowser(cartApi.getCookies());
        checkoutPage.load();

        checkoutPage.setBillingDetails(billingAddress);
        checkoutPage.placeOrder();
        Assert.assertEquals(checkoutPage.verifySuccessfulCheckout(), "Thank you. Your order has been received.");
    }

    @Test
    public void loginUsingDirectBankTransfer() throws IllegalAccessException, IOException, InterruptedException {

        String username = "demouser" + new FakerUtil().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demouser").
                setEmail(username + "@example.com");
        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);

        CartApi cartApi = new CartApi(signUpApi.getCookies());
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        Thread.sleep(5000);
        injectCookiesToBrowser(signUpApi.getCookies());
        Thread.sleep(5000);
        checkoutPage.load();
        checkoutPage.setBillingDetails(billingAddress).
                selectDirectBankTransfer().
                placeOrder();
        Assert.assertEquals(checkoutPage.verifySuccessfulCheckout(), "Thank you. Your order has been received.");
    }
}
