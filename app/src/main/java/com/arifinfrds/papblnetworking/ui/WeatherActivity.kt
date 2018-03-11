package com.arifinfrds.papblnetworking.ui

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.arifinfrds.papblnetworking.R
import com.arifinfrds.papblnetworking.extension.toast
import com.arifinfrds.papblnetworking.model.City
import com.arifinfrds.papblnetworking.model.Indonesia
import com.arifinfrds.papblnetworking.model.WeatherList
import com.arifinfrds.papblnetworking.model.WeatherResponse
import com.arifinfrds.papblnetworking.service.RestClient
import com.arifinfrds.papblnetworking.util.SpacesItemDecoration


import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.content_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList
import android.net.ConnectivityManager


class WeatherActivity : AppCompatActivity() {

    private var mCityName = "Malang"

    private var mWeathers: ArrayList<WeatherList>? = null
    private var mCity: City? = null
    private var mAdapter: WeatherAdapter? = null

    override fun onResume() {
        super.onResume()

        if (isNetworkConnected()) {
            attemptFetchWeather(mCityName)
        } else {
            toast("Network is not connected.")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        setSupportActionBar(toolbar)

        RestClient.initialize()


    }


    // MARK: - Private Method's
    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return cm.activeNetworkInfo != null
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager?

        mAdapter = WeatherAdapter(mWeathers!!, mCity!!)
        recyclerView.adapter = mAdapter

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
        RestClient.weatherService.fetchWeather(RestClient.APP_ID, "${mCityName},ID")
                .enqueue(object : Callback<WeatherResponse> {

                    override fun onFailure(call: Call<WeatherResponse>?, t: Throwable?) {
                        Log.d("TAG_RESPONSE", t?.localizedMessage)
                        t?.printStackTrace()
                    }

                    override fun onResponse(call: Call<WeatherResponse>?, response: Response<WeatherResponse>?) {
                        Log.d("TAG_RESPONSE", "response body string : " + response?.body().toString())
                        Log.d("TAG_RESPONSE", "response isSuccessful : " + response?.isSuccessful)

                        mWeathers?.clear()

                        if (response!!.isSuccessful() && response?.body() != null) {


                            val weatherResponse = response?.body()
                            Log.d("TAG_RESPONSE", "weatherResponse.cod : " + weatherResponse?.cod)

                            var weathers = java.util.ArrayList<WeatherList>()
                            weatherResponse!!.list!!.forEach { item ->
                                weathers.add(item)
                            }

                            mWeathers = weathers
                            mCity = weatherResponse.city

                            setupRecyclerView()

                        } else if (response.errorBody() != null) {
                            Log.d("TAG_RESPONSE", response.errorBody().toString())
                        }
                    }
                })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.weather, menu)


        val searchItem = menu.findItem(R.id.action_search)

        val searchManager = this@WeatherActivity.getSystemService(Context.SEARCH_SERVICE) as SearchManager

        var searchView: SearchView? = null
        if (searchItem != null) {
            searchView = searchItem.actionView as SearchView
        }
        if (searchView != null) {
            searchView!!.setSearchableInfo(searchManager.getSearchableInfo(this@WeatherActivity.componentName))

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    if (!searchView.isIconified()) {
                        searchView.setIconified(true);
                    }
                    searchItem.collapseActionView();
                    if (p0 != null) {
                        attemptFetchWeather(p0)
                    } else {
                        toast("Search cannot be empty.")
                    }
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    return false
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    private fun attemptFetchWeather(cityName: String) {
        if (!isCityAvailable(cityName)) {
            toast("Kota Anda tidak ada di database kami.")
            mWeathers?.clear()
            mAdapter?.notifyDataSetChanged()
        } else {
            toast("Kota Anda ada di database kami.")
            mCityName = cityName
            fetchWeather()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_search -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }


}
