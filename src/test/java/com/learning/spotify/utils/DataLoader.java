package com.learning.spotify.utils;

import java.util.Properties;

public class DataLoader {
    private static DataLoader dataLoader;
    private final Properties properties;
    String propertiesFilePath = PropertyUtils.getPropertiesFileBasePath() + "data.properties";

    private DataLoader() {
        properties = PropertyUtils.propertyLoader(propertiesFilePath);
    }

    public static DataLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getGetPlaylistId() {
        String prop = properties.getProperty("get_playlist_id");
        if (prop != null) return prop;
        else throw new RuntimeException("property get_playlist_id is not specified in the data.properties file");
    }

    public String getUpdatePlaylistId() {
        String prop = properties.getProperty("update_playlist_id");
        if (prop != null) return prop;
        else throw new RuntimeException("property update_playlist_id is not specified in the data.properties file");
    }

    public String getArtistId() {
        String prop = properties.getProperty("artist_id");
        if (prop != null) return prop;
        else throw new RuntimeException("property artist_id is not specified in the data.properties file");
    }

    public String getArtistName() {
        String prop = properties.getProperty("artist_name");
        if (prop != null) return prop;
        else throw new RuntimeException("property artist_name is not specified in the data.properties file");
    }

}
