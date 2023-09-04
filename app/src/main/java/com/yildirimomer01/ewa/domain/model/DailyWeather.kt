package com.yildirimomer01.ewa.domain.model

import java.time.LocalDate

data class DailyWeather(
    val date: LocalDate,
    val weatherType: WeatherType,
    val temperatureMax: Int,
    val temperatureMin: Int,
    val apparentTemperatureMax: Int,
    val apparentTemperatureMin: Int,
    val precipitationProbabilityMax: Int?,
    val windSpeedMax: Int
)
