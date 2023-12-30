package com.learning.spotify.apiClient;

import com.learning.spotify.utils.ConfigLoader;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationBuilder {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder().
                setBaseUri(ConfigLoader.getInstance().getBaseUri()).
                setBasePath(ResourcePathConstants.BASE_PATH).
                setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();
    }

    public static RequestSpecification getAccountRequestSpec() {
        return new RequestSpecBuilder().
                setBaseUri(ConfigLoader.getInstance().getBaseAccountUri()).
                setContentType(ContentType.URLENC).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }
}
