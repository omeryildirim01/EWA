package com.yildirimomer01.ewa.domain.model

import java.time.LocalDateTime

data class HourlyWeather(
    val time: LocalDateTime,
    val temperature: Int,
    val apparentTemperature: Int,
    val weatherType: WeatherType,
    val precipitationProbability: Int?,
    val windSpeed: Int
)
