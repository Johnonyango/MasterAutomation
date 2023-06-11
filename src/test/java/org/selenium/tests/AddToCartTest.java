package org.selenium.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.selenium.base.BaseClass;
import org.selenium.dataproviders.MyDataProvider;
import org.selenium.objects.Product;
import org.selenium.pageObjects.CartPage;
import org.selenium.pageObjects.HomePage;
import org.selenium.pageObjects.StorePage;
import org.selenium.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTest extends BaseClass {

    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("1234567")
    @TmsLink("1234")
    @Description("Description of Add to cart test")
    @Test(description = "Be able to add product to cart")
    public void addToCartFromStorePage() throws IllegalAccessException {
        Product product = new Product();
        CartPage cartPage = new StorePage(getDriver()).
                loadStorePage().getProductThumbnail().
                clickAddToCart(product.getName()).
                clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
    }

    @Test(description = "Be able to add product to cart", dataProvider = "featuredProducts", dataProviderClass = MyDataProvider.class)
    public void addToCartFeaturedProducts(Product product) throws IllegalAccessException {
        CartPage cartPage = new HomePage(getDriver()).load().
                getProductThumbnail().clickAddToCart(product.getName()).clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
    }

}
