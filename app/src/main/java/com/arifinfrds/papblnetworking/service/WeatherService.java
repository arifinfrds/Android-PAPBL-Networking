package com.arifinfrds.papblnetworking.service;

import com.arifinfrds.papblnetworking.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by arifinfrds on 3/9/18.
 */

public interface WeatherService {


    // appid=3805dd8eda02a9e61920a575cd81b269
    @GET("forecast?")
    Call<WeatherResponse> fetchWeather(@Query("appid") String appId, @Query("q") String cityNameAndCode);


}
