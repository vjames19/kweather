package com.github.vjames19.kweather.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import com.github.vjames19.kweather.R
import com.github.vjames19.kweather.domain.model.Forecast
import com.github.vjames19.kweather.domain.model.ForecastList
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.onClick

import kotlinx.android.synthetic.item_forecast.view.*


/**
 * Created by vjames19 on 10/24/15.
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        val view = parent.context.layoutInflater.inflate(R.layout.item_forecast, parent, false);
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindToForecast(weekForecast[position])
    }

    override fun getItemCount() = weekForecast.size()

    class ViewHolder(val view: View, val itemClick: (Forecast) -> Unit) :
            RecyclerView.ViewHolder(view) {

        fun bindToForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "${high.toString()}￿￿"
                itemView.minTemperature.text = "${low.toString()}￿￿"
                itemView.onClick { itemClick(forecast) }
            }
        }
    }
}