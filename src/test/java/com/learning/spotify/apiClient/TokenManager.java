package com.learning.spotify.apiClient;

import com.learning.spotify.tests.BaseTestConfig;
import com.learning.spotify.utils.ConfigLoader;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;

public class TokenManager {
    private static String access_token;
    private static Instant expiry_time;

    public synchronized static String getToken() {
        try {
            if (access_token == null || Instant.now().isAfter(expiry_time)) {
                System.out.println("Renewing token ...");
                Response response = renewToken();
                access_token = response.path("access_token");
                int expiryDurationInSeconds = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds - 300);
            } else {
                System.out.println("Token is good to use");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ABORT!!! Failed to get token");
        }
        return access_token;
    }

    private static Response renewToken() {
        HashMap<String, String> formParams = new HashMap<String, String>();
        formParams.put("client_id", ConfigLoader.getInstance().getClientId());
        formParams.put("client_secret", ConfigLoader.getInstance().getClientSecret());
        formParams.put("refresh_token", BaseTestConfig.refreshToken);
        formParams.put("grant_type", ConfigLoader.getInstance().getGrantType());

        Response response = RestRequestProcessor.postAccount(formParams);

        if (response.statusCode() != 200) {
            throw new RuntimeException("ABORT!!! Renew Token failed");
        }
        return response;
    }
}
