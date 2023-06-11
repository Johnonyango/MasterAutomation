package org.selenium.dataproviders;

import org.selenium.objects.Product;
import org.selenium.utils.JacksonUtils;

import java.io.IOException;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "featuredProducts", parallel = true)
    public static Object[] getFeaturedProducts() throws IOException {
        return JacksonUtils.deserialization("products.json", Product[].class);
    }

}
