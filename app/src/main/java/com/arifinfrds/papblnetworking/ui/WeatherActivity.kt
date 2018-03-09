package com.arifinfrds.papblnetworking.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.arifinfrds.papblnetworking.R
import com.arifinfrds.papblnetworking.model.Example
import com.arifinfrds.papblnetworking.service.RestClient
import com.arifinfrds.papblnetworking.service.WeatherService

import kotlinx.android.synthetic.main.activity_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        setSupportActionBar(toolbar)

        RestClient.initialize()
        fetchWeather()

    }

    private fun fetchWeather() {
        RestClient.weatherService
                .getWeather(RestClient.APP_ID, WeatherService.ID_KOTA_MALANG)
                .enqueue(object : Callback<Example> {
                    override fun onFailure(call: Call<Example>?, t: Throwable?) {
                        Log.d("TAG_RESPONSE", t?.localizedMessage)
                        t?.printStackTrace()

                    }

                    override fun onResponse(call: Call<Example>?, response: Response<Example>?) {
                        Log.d("TAG_RESPONSE", "response body string : " + response?.body().toString())
                        Log.d("TAG_RESPONSE", "response isSuccessful : " + response?.isSuccessful)

                        if (response!!.isSuccessful() && response?.body() != null) {

                        } else if (response.errorBody() != null) {
                        }
                    }
                })
    }

}
