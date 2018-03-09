package com.arifinfrds.papblnetworking.service;

import com.arifinfrds.papblnetworking.model.Example;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arifinfrds on 3/9/18.
 */

public class RestClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String APP_ID = "3805dd8eda02a9e61920a575cd81b269";

    public static WeatherService weatherService;

    public static void initialize() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherService = retrofit.create(WeatherService.class);
    }
}
