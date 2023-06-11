package org.selenium.utils;

import com.github.javafaker.Faker;

public class FakerUtil {
    public long generateRandomNumber(){
        Faker faker = new Faker();
        return faker.number().randomNumber();
    }
}
