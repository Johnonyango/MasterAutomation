package org.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.base.BasePageObject;
import org.selenium.objects.BillingAddress;
import org.selenium.objects.User;

public class CheckoutPage extends BasePageObject {
    //Login Details
    By showLoginLink = By.cssSelector(".showlogin");
    By username = By.cssSelector("#username");
    By password = By.cssSelector("#password");
    By loginBtn = By.cssSelector("button[value='Login']");
    By firstname = By.cssSelector("#billing_first_name");
    By lastname = By.cssSelector("#billing_last_name");
    By billingAddress = By.cssSelector("#billing_address_1");
    By town = By.cssSelector("#billing_city");
    By zipcode = By.cssSelector("#billing_postcode");
    By emailAddress = By.cssSelector("#billing_email");
    By placeOrderBtn = By.cssSelector("#place_order");
    By successMessage = By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");
    By overlay = By.cssSelector(".blockUI.blockOverlay");
    By countryDropDown = By.id("billing_country");
    By stateDropdown = By.id("billing_state");
    By direct_bank_transfer = By.id("payment_method_bacs");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public CheckoutPage showLogin(){
        WebElement e = waitForElementToBeClickable(showLoginLink);
        e.click();
        return this;
    }

    private CheckoutPage enterUsername(String uname){
        WebElement e = waitForElementVisibility(username);
        e.clear();
        e.sendKeys(uname);
        return  this;
    }
    private CheckoutPage enterPassword(String pwd){
        WebElement e = waitForElementVisibility(password);
        e.clear();
        e.sendKeys(pwd);
        return  this;
    }
    public CheckoutPage clickLogin(){
        WebElement e = waitForElementToBeClickable(loginBtn);
        e.click();
        return this;
    }

    public CheckoutPage login(User user){
        return enterUsername(user.getUsername()).enterPassword(user.getPassword()).clickLogin();
    }
//    public CheckoutPage login(String uname, String pwd){
//        enterUsername(uname).enterPassword(pwd).clickLogin();
//        return this;
//    }


    private CheckoutPage enterFirstName(String fname){
        WebElement e = waitForElementVisibility(firstname);
        e.clear();
        e.sendKeys(fname);
        return this;
    }
    private CheckoutPage enterLastName(String lname){
        WebElement e = waitForElementVisibility(lastname);
        e.clear();
        e.sendKeys(lname);
        return this;
    }
    private CheckoutPage enterStreetAddress(String billing_Address){
        WebElement e = waitForElementVisibility(billingAddress);
        e.clear();
        e.sendKeys(billing_Address);
        return this;
    }

    public CheckoutPage selectCountry(String country){
        WebElement countryDropdown = driver.findElement(countryDropDown);
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
        return this;
    }

    public CheckoutPage selectState(String state){
        WebElement countryDropdown = driver.findElement(stateDropdown);
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(state);
        return this;
    }

    private CheckoutPage enterTown(String towname){
        WebElement e = waitForElementVisibility(town);
        e.clear();
        e.sendKeys(towname);
        return this;
    }
    private CheckoutPage enterZipCode(String zip_code){
        WebElement e = waitForElementVisibility(zipcode);
        e.clear();
        e.sendKeys(zip_code);
        return this;
    }
    private CheckoutPage enterEmailAddress(String email){
        WebElement e = waitForElementVisibility(emailAddress);
        e.clear();
        e.sendKeys(email);
        return this;
    }

    public CheckoutPage selectDirectBankTransfer(){
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(direct_bank_transfer));
        if (!e.isSelected()){
            e.click();
        }
        return  this;
    }


    public CheckoutPage placeOrder(){
        waitForOverlayToDisappear(overlay);
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String verifySuccessfulCheckout(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

    public CheckoutPage setBillingDetails(BillingAddress billingAddress){
       return enterFirstName(billingAddress.getFirstName()).
               enterLastName(billingAddress.getLastName()).
               selectCountry(billingAddress.getCountry()).
               enterTown(billingAddress.getCity()).
               selectState(billingAddress.getState()).
               enterStreetAddress(billingAddress.getStreetAddress()).
               enterZipCode(billingAddress.getPostalCode()).
               enterEmailAddress(billingAddress.getEmail());
    }
//    public CheckoutPage enterBillingDetails(){
//        enterFirstName("John").
//                enterLastName("Doe").
//                enterStreetAddress("1254").
//                enterTown("New York").
//                enterZipCode("00100").
//                enterEmailAddress("someone@example.com");
//        return this;
//    }


}
