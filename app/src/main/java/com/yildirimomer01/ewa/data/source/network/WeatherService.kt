package com.yildirimomer01.ewa.data.source.network

import com.yildirimomer01.ewa.data.dto.WeatherWrapperDto
import com.yildirimomer01.ewa.util.Mockable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val TIMEZONE = "timezone=auto"
const val FORECAST_DAYS = "forecast_days=7"
const val DAILY =
    "daily=weathercode,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,precipitation_sum,precipitation_probability_max,windspeed_10m_max"
const val HOURLY =
    "hourly=temperature_2m,apparent_temperature,precipitation_probability,weathercode,windspeed_10m"
const val FORECAST_URL = "v1/forecast?$HOURLY&$DAILY&$TIMEZONE&$FORECAST_DAYS"

interface WeatherService {

    @GET(FORECAST_URL)
    @Mockable(fileName = "weather.json", mockEnabled = true)
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): Response<WeatherWrapperDto>
}
