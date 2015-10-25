package com.github.vjames19.kweather.domain.mappers

import com.github.vjames19.kweather.data.Forecast
import com.github.vjames19.kweather.data.ForecastResult
import com.github.vjames19.kweather.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import com.github.vjames19.kweather.domain.model.Forecast as ModelForecast

/**
 * Created by vjames19 on 10/24/15.
 */
class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}