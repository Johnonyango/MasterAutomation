//package org.selenium.tests;
//
//import org.openqa.selenium.By;
//import org.selenium.base.BaseClass;
//import org.selenium.objects.BillingAddress;
//import org.selenium.objects.Product;
//import org.selenium.objects.User;
//import org.selenium.pageObjects.CartPage;
//import org.selenium.pageObjects.CheckoutPage;
//import org.selenium.pageObjects.HomePage;
//import org.selenium.pageObjects.StorePage;
//import org.selenium.utils.JacksonUtils;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//public class TestClass extends BaseClass {
//
//    @Test
//    public void testing() throws InterruptedException, IOException, IllegalAccessException {
//
//
//        BillingAddress billingAddress = JacksonUtils.deserialization("BillingAddress.json", BillingAddress.class);
//        Product product = new Product(1215);
//        HomePage homePage = new HomePage(getDriver()).load();
//        StorePage storePage = homePage.clickStoreObject();
//        storePage.searchObject();
//        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
//        storePage.clickAddToCart(product.getName());
//        CartPage cartPage = storePage.clickViewCart();
//        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
//        CheckoutPage checkoutPage = cartPage.
//                clickCheckoutBtn().
//                setBillingDetails(billingAddress).selectDirectBankTransfer().placeOrder();
//        Assert.assertEquals(checkoutPage.verifySuccessfulCheckout(), "Thank you. Your order has been received.");
//    }
//}
