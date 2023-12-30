package com.learning.spotify.utils;

import java.util.Properties;

public class ConfigLoader {
    private static ConfigLoader configLoader;
    private final Properties properties;
    String propertiesFilePath = PropertyUtils.getPropertiesFileBasePath() + "config.properties";

    private ConfigLoader() {
        properties = PropertyUtils.propertyLoader(propertiesFilePath);
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getClientId() {
        String prop = properties.getProperty("client_id");
        if (prop != null) return prop;
        else throw new RuntimeException("property client_id is not specified in the config.properties file");
    }

    public String getClientSecret() {
        String prop = properties.getProperty("client_secret");
        if (prop != null) return prop;
        else throw new RuntimeException("property client_secret is not specified in the config.properties file");
    }

    public String getGrantType() {
        String prop = properties.getProperty("grant_type");
        if (prop != null) return prop;
        else throw new RuntimeException("property grant_type is not specified in the config.properties file");
    }


    public String getUser() {
        String prop = properties.getProperty("user_id");
        if (prop != null) return prop;
        else throw new RuntimeException("property user_id is not specified in the config.properties file");
    }

    public String getBaseUri() {
        String prop = properties.getProperty("base_uri");
        if (prop != null) return prop;
        else throw new RuntimeException("property base_uri is not specified in the config.properties file");
    }

    public String getBaseAccountUri() {
        String prop = properties.getProperty("account_base_uri");
        if (prop != null) return prop;
        else throw new RuntimeException("property account_base_uri is not specified in the config.properties file");
    }


}
