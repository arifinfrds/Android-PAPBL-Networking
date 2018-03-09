package com.arifinfrds.papblnetworking.service;

import com.arifinfrds.papblnetworking.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by arifinfrds on 3/9/18.
 */

public interface WeatherService {

    String ID_KOTA_MALANG = "1636722";

    // appid=3805dd8eda02a9e61920a575cd81b269&id=1636722
    @GET("forecast?")
    Call<WeatherResponse> getWeather(@Query("appid") String appId, @Query("id") String cityId);


}
