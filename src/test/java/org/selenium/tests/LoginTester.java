package org.selenium.tests;

import org.selenium.base.BaseClass;
import org.selenium.objects.BillingAddress;
import org.selenium.objects.User;
import org.selenium.pageObjects.LoginPage;
import org.selenium.utils.ConfigLoader;
import org.selenium.utils.JacksonUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTester extends BaseClass {

    @Test
    public void login() throws IOException, IllegalAccessException {
//        BillingAddress billingAddress = JacksonUtils.deserialization("billingAddress.json", BillingAddress.class);
        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(user);
    }
}
