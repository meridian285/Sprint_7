package ru.yandex.practikum.config;

import io.restassured.RestAssured;

public class Config {
    private final static String URL = "https://qa-scooter.praktikum-services.ru";


    public static String getBaseUri() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";

        return URL;
    }
}