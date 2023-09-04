package com.yildirimomer01.ewa.data.dto

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class HourlyUnitsDto(
    @SerialName("time")
    val time: String,
    @SerialName("temperature_2m")
    val temperature2m: String,
    @SerialName("apparent_temperature")
    val apparentTemperature: String,
    @SerialName("precipitation_probability")
    val precipitationProbability: String,
    @SerialName("weathercode")
    val weatherCode: String,
    @SerialName("windspeed_10m")
    val windSpeed10m: String
)
