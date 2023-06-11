package org.selenium.dataproviders;

import org.selenium.objects.Product;
import org.selenium.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class MyDataProvider {
    @DataProvider(name = "featuredProducts", parallel = true)
    public static Object[] getFeaturedProducts() throws IOException {
        return JacksonUtils.deserialization("products.json", Product[].class);
    }

}
