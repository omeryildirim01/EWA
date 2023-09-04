package com.yildirimomer01.ewa.domain.model

data class WeatherInfo(
    val dailyWeather: List<DailyWeather> = listOf(),
    val hourlyWeatherInfo: HourlyWeatherInfo? = null,
    val hourlyWeather: List<HourlyWeather> = listOf()
)
