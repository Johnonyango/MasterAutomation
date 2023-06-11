package org.selenium.api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.selenium.objects.User;
import org.selenium.utils.ConfigLoader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SignUpApi {
    private Cookies cookies;

    public Cookies getCookies(){
        return cookies;
    }

    private String fetchRegisterNonceValueUsingGroovy() throws IllegalAccessException {
        Response response = getAccount();
        return response.htmlPath().get("**.findAll { it.@name == 'woocommerce-register-nonce' }.@value");
    }
    public String fetchRegisterNonceValueUsingJsoup() throws IllegalAccessException {
        Response response = getAccount();
        Document doc = Jsoup.parse(response.body().prettyPrint());
        Element element = doc.selectFirst("#woocommerce-register-nonce");
        return element.attr("value");
    }
    private Response getAccount() throws IllegalAccessException {
        cookies = new Cookies();
        Response response = given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                cookies(cookies).
                log().all().
        when().
                get("/account").
        then().
                log().all().
                extract().
                response();
        if (response.getStatusCode() != 200){
            throw new RuntimeException("failed to fetch the account, HTTP Status code: "+ response.getStatusCode());
        }
        return response;
    }

    public Response register(User user) throws IllegalAccessException {
        cookies = new Cookies();
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap <String, String> formParams = new HashMap<>();
        formParams.put("username", user.getUsername());
        formParams.put("email", user.getEmail());
        formParams.put("password", user.getPassword());
        formParams.put("woocommerce-register-nonce", fetchRegisterNonceValueUsingJsoup());
        formParams.put("register", "Register");

        Response response = given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                log().all().
        when().
                post("/account").
        then().
                log().all().
                extract().
                response();
        if (response.getStatusCode() != 302){
            throw new RuntimeException("failed to register the account, HTTP Status code: "+ response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
