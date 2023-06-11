package org.selenium.utils;

import org.selenium.constants.EvnType;

import java.io.File;
import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;
    String stage_configFilePath = "src"+ File.separator+"test"+File.separator+"resources"+File.separator+ "test_config.properties";
    String dev_configFilePath = "src"+ File.separator+"test"+File.separator+"resources"+File.separator+ "dev_config.properties";
    String prod_configFilePath = "src"+ File.separator+"test"+File.separator+"resources"+File.separator+ "prod_config.properties";


    private ConfigLoader() throws IllegalAccessException {
        String env = System.getProperty("env", String.valueOf(EvnType.STAGE));
        switch (EvnType.valueOf(env)){
            case STAGE:
                properties = PropertyUtils.propertyLoader(stage_configFilePath);
                break;
            case DEV:
                properties = PropertyUtils.propertyLoader(dev_configFilePath);
                break;
            case PRODUCTION:
                properties = PropertyUtils.propertyLoader(prod_configFilePath);
                break;
            default:
                throw new IllegalAccessException("invalid env type: "+ env);
        }

    }

    public static ConfigLoader getInstance() throws IllegalAccessException {
        if (configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not present in the properties file");
    }

    public String getUsername(){
        String prop = properties.getProperty("username");
        if (prop != null) return prop;
        else throw new RuntimeException("property password is not present in the properties file");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        else throw new RuntimeException("property password is not present in the properties file");
    }
}
