package com.yildirimomer01.ewa.domain.model

data class HourlyWeatherInfo(
    val weatherData: List<HourlyWeather>,
    val currentWeatherData: HourlyWeather?,
    val highTemperature: Int,
    val lowTemperature: Int,
    val precipitationProbability: Int?
)
