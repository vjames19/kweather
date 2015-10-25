package com.github.vjames19.kweather.domain.commands

import com.github.vjames19.kweather.data.ForecastRequest
import com.github.vjames19.kweather.domain.mappers.ForecastDataMapper
import com.github.vjames19.kweather.domain.model.ForecastList

/**
 * Created by vjames19 on 10/24/15.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode);
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute());
    }
}