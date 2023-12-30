package com.learning.spotify.utils;

import java.io.*;
import java.nio.file.Path;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to load properties file " + filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found at " + filePath);
        }
        return properties;
    }

    public static void writeValueToProperties(String filePath, String key, String valueToWrite) {
        Properties properties = propertyLoader(filePath);  // Load existing properties
        properties.setProperty(key, valueToWrite);       // Set the new value

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            properties.store(outputStream, "Updated properties");  // Write to file
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to write properties to file " + filePath);
        }
    }

    public static String getPropertiesFileBasePath() {
        String environment = System.getProperty("TEST_ENVIRONMENT");
        if (environment == null) {
            throw new IllegalStateException("TEST_ENVIRONMENT system property not set");
        }
        System.out.println("Properties file base path :" + Path.of("src", "test", "resources", environment) + File.separator);
        return Path.of("src", "test", "resources", environment) + File.separator;
    }
}
