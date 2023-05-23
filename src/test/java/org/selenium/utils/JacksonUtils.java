package org.selenium.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
    public static <T> T deserialization(String filename, Class<T> T) throws IOException {
        InputStream inputStream = JacksonUtils.class.getClassLoader().getResourceAsStream(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream, T);
    }
}
