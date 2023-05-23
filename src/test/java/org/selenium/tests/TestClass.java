package org.selenium.tests;

import org.openqa.selenium.By;
import org.selenium.base.BaseClass;
import org.selenium.objects.BillingAddress;
import org.selenium.objects.Product;
import org.selenium.objects.User;
import org.selenium.pageObjects.CartPage;
import org.selenium.pageObjects.CheckoutPage;
import org.selenium.pageObjects.HomePage;
import org.selenium.pageObjects.StorePage;
import org.selenium.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestClass extends BaseClass {

    @Test
    public void testing() throws InterruptedException, IOException {

        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();

        BillingAddress billingAddress = JacksonUtils.deserialization("BillingAddress.json", BillingAddress.class);


        Product product = new Product(1215);
//        BillingAddress billingAddress = new BillingAddress().
//                setFirstName("John").
//                setLastName("Doe").
//                setCity("New York").
//                setPostalCode("00100").
//                setEmail("someone@example.com").
//                setStreetAddress("someone@example.com");
//        BillingAddress billingAddress = new BillingAddress("John", "Doe", "New York", "New York",
//                "00100", "someone@example.com");


        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.clickStoreObject();
        storePage.searchObject();
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCart(product.getName());
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckoutPage checkoutPage = cartPage.
                clickCheckoutBtn().
                setBillingDetails(billingAddress).selectDirectBankTransfer().placeOrder();
        Assert.assertEquals(checkoutPage.verifySuccessfulCheckout(), "Thank you. Your order has been received.");











        //        driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
    }
}
