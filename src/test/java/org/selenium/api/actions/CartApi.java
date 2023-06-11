package org.selenium.api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.selenium.utils.ConfigLoader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CartApi {
    private Cookies cookies;
    public CartApi(){}

    public CartApi(Cookies cookies){

    }

    public Cookies getCookies() {
        return cookies;
    }


    public Response addToCart(int product_id, int quantity) throws IllegalAccessException {
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("product_sku", "");
        formParams.put("product_id", product_id);
        formParams.put("quantity", quantity);

        if (cookies==null){
            cookies = new Cookies();
        }

        Response response = given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                log().all().
        when().
                post("/?wc-ajax=add_to_cart").
        then().
                log().all().
                extract().
                response();
        if (response.getStatusCode() != 200){
            throw new RuntimeException("failed to add product " +product_id+ " to the cart"+ "HTTP Status code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
