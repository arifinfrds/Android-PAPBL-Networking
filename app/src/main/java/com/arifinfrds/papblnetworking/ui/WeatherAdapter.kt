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

/**
 * Created by arifinfrds on 3/10/18.
 */
class WeatherAdapter
(
        val weathers: ArrayList<String>,
        val context: Context

) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_weather, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var weather = weathers[position]



//        Glide.with(context).load(post.imageURL).into(holder!!.contentImageView)
//
//        holder?.titleTextView?.setText(post.title)
//        holder?.subtitleTextView?.setText(post.subtitle)
//        holder?.descriptionTextView?.setText(post.description)
//        holder?.timeTextView?.setText(post.time)

        // cara lebih singkat lagi
        holder?.cardView?.setOnClickListener {
            // postListener.onPostClick(post)
        }

    }

    override fun getItemCount(): Int {
        return weathers.count()
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        // MARK: - Public Properties
        val cardView: CardView
        val contentImageView: ImageView
        val titleTextView: TextView
        val subtitleTextView: TextView
        val descriptionTextView: TextView
        val timeTextView: TextView

        // MARK: - Initialization
        init {
            cardView = itemView?.findViewById(R.id.cardView) as CardView
            contentImageView = itemView?.findViewById(R.id.contentImageView) as ImageView
            titleTextView = itemView?.findViewById(R.id.titleTextView) as TextView
            subtitleTextView = itemView?.findViewById(R.id.subtitleTextView) as TextView
            descriptionTextView = itemView?.findViewById(R.id.descriptionTextView) as TextView
            timeTextView = itemView?.findViewById(R.id.timeTextView) as TextView

        }
    }
}