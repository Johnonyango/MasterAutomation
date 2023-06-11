package org.selenium.utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtil {
    public List<Cookie>convertRestAssuredCookiesToSeleniumCookies(Cookies cookies){
        List<Cookie> seleniumCookies = new ArrayList<>();
        List<io.restassured.http.Cookie> restAssuredCookies = new ArrayList<>();
        restAssuredCookies = cookies.asList();
        for (io.restassured.http.Cookie cookie : restAssuredCookies){
            seleniumCookies.add(new Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(),
                    cookie.getExpiryDate(), cookie.isSecured(), cookie.isHttpOnly(), cookie.getSameSite()));
        }
        return seleniumCookies;
    }
}
