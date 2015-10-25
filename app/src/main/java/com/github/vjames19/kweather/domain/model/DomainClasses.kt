package com.github.vjames19.kweather.domain.model

data internal class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)
data internal class Forecast(val date: String, val description: String, val high: Int, val low: Int)