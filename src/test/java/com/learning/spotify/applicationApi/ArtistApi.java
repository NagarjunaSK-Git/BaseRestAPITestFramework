package com.learning.spotify.applicationApi;

import com.learning.spotify.apiClient.ResourcePathConstants;
import com.learning.spotify.apiClient.RestRequestProcessor;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

import static com.learning.spotify.apiClient.TokenManager.getToken;

public class ArtistApi {

    @Step
    public static Response get(String artistID) {
        return RestRequestProcessor.get(ResourcePathConstants.ARTISTS + "/" + artistID, getToken());
    }

    @Step
    public static Response get(String artistID, HashMap<String, String> queryParamVal) {
        return RestRequestProcessor.get(ResourcePathConstants.ARTISTS + "/" + artistID + ResourcePathConstants.ALBUMS, queryParamVal, getToken());
    }
}
