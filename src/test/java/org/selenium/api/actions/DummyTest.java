package org.selenium.api.actions;

import org.selenium.objects.User;
import org.selenium.utils.FakerUtil;

public class DummyTest {
    public static void main(String[] args) throws IllegalAccessException {
//        System.out.println(new SignUpApi().fetchRegisterNonceValueUsingJsoup());
//        new SignUpApi().fetchRegisterNonceValueUsingJsoup();

        String username = "demouser" + new FakerUtil().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demouser").
                setEmail(username + "@example.com");
        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);
        System.out.println("RGISTER COOKIES "+signUpApi.getCookies());

        CartApi cartApi = new CartApi(signUpApi.getCookies());
        cartApi.addToCart(1215, 1);
        System.out.println("Cart Cookies :"+ cartApi.getCookies());
    }
}
