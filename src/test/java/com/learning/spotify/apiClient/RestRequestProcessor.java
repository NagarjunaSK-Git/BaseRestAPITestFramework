package com.learning.spotify.apiClient;

import com.learning.spotify.pojo.IRequestResponseBase;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestRequestProcessor {

    public static Response post(String path, String token, IRequestResponseBase requestPOJO) {
        return given(SpecificationBuilder.getRequestSpec()).
                body(requestPOJO).
                auth().oauth2(token).
                when().post(path).
                then().spec(SpecificationBuilder.getResponseSpec()).
                extract().
                response();
    }

    public static Response postAccount(HashMap<String, String> formParams) {
        return given(SpecificationBuilder.getAccountRequestSpec()).
                formParams(formParams).
                when().post(ResourcePathConstants.API + ResourcePathConstants.TOKEN).
                then().spec(SpecificationBuilder.getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String path, String token) {
        return given(SpecificationBuilder.getRequestSpec()).
                auth().oauth2(token).
                when().get(path).
                then().spec(SpecificationBuilder.getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String path, Map<String, String> queryParamVal, String token) {
        return given(SpecificationBuilder.getRequestSpec()).
                queryParams(queryParamVal).
                auth().oauth2(token).
                when().get(path).
                then().spec(SpecificationBuilder.getResponseSpec()).
                extract().
                response();
    }

    public static Response update(String path, String token, IRequestResponseBase requestPojo) {
        return given(SpecificationBuilder.getRequestSpec()).
                auth().oauth2(token).
                body(requestPojo).
                when().put(path).
                then().spec(SpecificationBuilder.getResponseSpec()).
                extract().
                response();
    }
}
