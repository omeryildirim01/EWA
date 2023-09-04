package com.yildirimomer01.ewa.data.dto

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class HourlyDto(
    @SerialName("time")
    val time: List<String>,
    @SerialName("temperature_2m")
    val temperature: List<Double>,
    @SerialName("apparent_temperature")
    val apparentTemperature: List<Double>,
    @SerialName("precipitation_probability")
    val precipitationProbability: List<Int>,
    @SerialName("weathercode")
    val weatherCode: List<Int>,
    @SerialName("windspeed_10m")
    val windSpeed: List<Double>
)
