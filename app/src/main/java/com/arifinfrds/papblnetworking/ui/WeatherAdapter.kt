package com.arifinfrds.papblnetworking.ui

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.arifinfrds.papblnetworking.R
import com.arifinfrds.papblnetworking.model.WeatherList
import com.squareup.picasso.Picasso
import java.text.DecimalFormat
import java.util.ArrayList

/**
 * Created by arifinfrds on 3/10/18.
 */
class WeatherAdapter
(
        val items: ArrayList<WeatherList>,
        val context: Context

) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_weather, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var item = items[position]

        val iconURL = "http://openweathermap.org/img/w/${item.weather[0].icon}.png"
        Picasso.get().load(iconURL).into(holder?.thumbnailImageView);

        holder?.titleTextView?.setText(item.weather[0].main)
        holder?.subtitleTextView?.setText(item.weather[0].description)

        holder?.descriptionTextView?.setText("Humidity : ${item.main.humidity} | Temperature : ${getCelcius(item.main.temp)} degree Celcius.")
        holder?.timeTextView?.setText(item.dtTxt)

    }

    override fun getItemCount(): Int {
        return items.count()
    }

    fun getCelcius(kelvin: Double): Double {
        val df = DecimalFormat("#.##")

        val result = kelvin - 273.15
        val degreeString = df.format(result)
        return degreeString.toDouble()
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        // MARK: - Public Properties
        val cardView: CardView
        val titleTextView: TextView
        val subtitleTextView: TextView
        val descriptionTextView: TextView
        val timeTextView: TextView
        val thumbnailImageView: ImageView

        // MARK: - Initialization
        init {
            cardView = itemView?.findViewById(R.id.cardView) as CardView
            titleTextView = itemView?.findViewById(R.id.titleTextView) as TextView
            subtitleTextView = itemView?.findViewById(R.id.subtitleTextView) as TextView
            descriptionTextView = itemView?.findViewById(R.id.descriptionTextView) as TextView
            timeTextView = itemView?.findViewById(R.id.timeTextView) as TextView
            thumbnailImageView = itemView?.findViewById(R.id.thumbnailImageView)

        }
    }
}