//package org.selenium.tests;
//
//import org.selenium.base.BaseClass;
//import org.selenium.objects.BillingAddress;
//import org.selenium.objects.User;
//import org.selenium.pageObjects.CartPage;
//import org.selenium.pageObjects.CheckoutPage;
//import org.selenium.pageObjects.HomePage;
//import org.selenium.pageObjects.StorePage;
//import org.selenium.utils.ConfigLoader;
//import org.selenium.utils.JacksonUtils;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//public class Test2 extends BaseClass {
//
//    @Test
//    public void checkoutAndLogin() throws InterruptedException, IOException, IllegalAccessException {
////        getDriver().get("https://askomdch.com/");
////        getDriver().manage().window().maximize();
////        BillingAddress billingAddress = new BillingAddress();
////        billingAddress.setFirstName("John");
////        billingAddress.setLastName("Doe");
////        billingAddress.setCity("New York");
////        billingAddress.setPostalCode("00100");
////        billingAddress.setEmail("someone@example.com");
////        billingAddress.setStreetAddress("New York");
////        BillingAddress billingAddress = new BillingAddress("John", "Doe", "New York", "New York",
////                "00100", "someone@example.com");
//
//
//        BillingAddress billingAddress = JacksonUtils.deserialization("billingAddress.json", BillingAddress.class);
////        User user = JacksonUtils.deserialization("user.json", User.class);
//        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
//
//
//        HomePage homePage = new HomePage(getDriver()).load();
//        StorePage storePage = homePage.clickStoreObject();
//        storePage.searchObject();
//        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
//        storePage.clickAddToCart("Blue");
//        CartPage cartPage = storePage.clickViewCart();
//        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
//        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
//        checkoutPage.showLogin();
//        checkoutPage.login(user);
//        checkoutPage.setBillingDetails(billingAddress);
//        checkoutPage.placeOrder();
//        Assert.assertEquals(checkoutPage.verifySuccessfulCheckout(), "Thank you. Your order has been received.");
//    }
//}
