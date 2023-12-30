package com.learning.spotify.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public static String generateName() {
        Faker faker = new Faker();
        return "Playlist Rest Assured" + faker.regexify("[A-Za-z0-9]{10}");
    }

    public static String generateDescription() {
        Faker faker = new Faker();
        return "Description Rest Assured" + faker.regexify("[ A-Za-z0-9]{50}");
    }
}
