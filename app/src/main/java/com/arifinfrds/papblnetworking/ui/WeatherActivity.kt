package com.arifinfrds.papblnetworking.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.arifinfrds.papblnetworking.R
import com.arifinfrds.papblnetworking.extension.toast
import com.arifinfrds.papblnetworking.model.Indonesia
import com.arifinfrds.papblnetworking.model.WeatherResponse
import com.arifinfrds.papblnetworking.service.RestClient
import com.arifinfrds.papblnetworking.util.SpacesItemDecoration


import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.content_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherActivity : AppCompatActivity() {

    private val cityName = "Malang"
    private var cities = Indonesia.getBigCities()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        setSupportActionBar(toolbar)

        RestClient.initialize()

        if (!isCityAvailable(cityName)) {
            toast("Kota Anda tidak ada di database kami.")
        } else {
            toast("Kota Anda ada di database kami.")
            fetchWeather()
            setupRecyclerView()
        }

    }

    // MARK: - Private Method's
    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = WeatherAdapter(cities, this)

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.space_between_card)
        recyclerView.addItemDecoration(SpacesItemDecoration(spacingInPixels))
    }

    private fun isCityAvailable(cityName: String): Boolean {
        Indonesia.getBigCities().forEach { city ->
            if (cityName.equals(city, true)) {
                return true
            }
        }
        return false
    }

    private fun fetchWeather() {
        RestClient.weatherService.fetchWeather(RestClient.APP_ID, "${cityName},ID")
                .enqueue(object : Callback<WeatherResponse> {
                    override fun onFailure(call: Call<WeatherResponse>?, t: Throwable?) {
                        Log.d("TAG_RESPONSE", t?.localizedMessage)
                        t?.printStackTrace()
                    }

                    override fun onResponse(call: Call<WeatherResponse>?, response: Response<WeatherResponse>?) {
                        Log.d("TAG_RESPONSE", "response body string : " + response?.body().toString())
                        Log.d("TAG_RESPONSE", "response isSuccessful : " + response?.isSuccessful)

                        if (response!!.isSuccessful() && response?.body() != null) {
                            val weatherResponse = response?.body()
                            Log.d("TAG_RESPONSE", "weatherResponse: " + weatherResponse?.cod)

                        } else if (response.errorBody() != null) {
                        }
                    }
                })
    }

}
