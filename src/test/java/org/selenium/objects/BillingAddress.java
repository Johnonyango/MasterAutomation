package org.selenium.objects;

public class BillingAddress {
    private String firstName;
    private String lastName;
    private String country;
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;
    private String email;

    public BillingAddress(){}

    public BillingAddress(String firstName, String lastName, String streetAddress, String city, String postalCode, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.streetAddress=streetAddress;
        this.city=city;
        this.postalCode=postalCode;
        this.email=email;
    }

    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return  this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return  this;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public BillingAddress setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    public String getCity() {
        return city;
    }

    public BillingAddress setCity(String city) {
        this.city = city;
        return  this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public BillingAddress setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BillingAddress setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public BillingAddress setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getState() {
        return state;
    }

    public BillingAddress setState(String state) {
        this.state = state;
        return  this;
    }
}
