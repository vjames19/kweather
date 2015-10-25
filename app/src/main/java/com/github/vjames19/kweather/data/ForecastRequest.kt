package com.github.vjames19.kweather.data

import com.google.gson.Gson
import java.net.URL

/**
 * Created by vjames19 on 10/24/15.
 */
public class ForecastRequest(val zipCode: String) {

    companion object {
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?APPID=5a13f9661790be7b7c416726474eed9a&mode=json&units=metric&cnt=7&q="
    }

    public fun execute(): ForecastResult {
        val forecastJsonStr = URL(URL + zipCode).readText();
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java);
    }
}