package com.learning.spotify.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTestConfig {

    // Default QA is the environment options
    public static String environment = "";
    public static String refreshToken = "";

    public static String setEnvironmentVariable() {
        String testEnvironment = System.getProperty("TEST_ENVIRONMENT");
        return environment = testEnvironment != null && !testEnvironment.isEmpty() ? testEnvironment : "qa";
    }

    public static String setRefreshToken() {
        String token = System.getProperty("REFRESH_TOKEN");
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Refresh Token Not Passed for the Suite. Please pass the token for execution");
        }
        System.out.println("Passed refresh token is :" + token);
        return token;
    }

    @BeforeSuite(alwaysRun = true)
    public void setupSuite() {
        System.out.println("----------------BEGINNING TEST SUITE----------------");
        environment = setEnvironmentVariable();
        refreshToken = setRefreshToken();

    }

    @BeforeMethod(alwaysRun = true)
    public void setTestStartDetails(Method m) {
        System.out.println("STARTING TEST: " + m.getName());
        System.out.println("THREAD ID: " + Thread.currentThread().threadId());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        System.out.println("----------------ENDING TEST SUITE----------------");
    }
}
