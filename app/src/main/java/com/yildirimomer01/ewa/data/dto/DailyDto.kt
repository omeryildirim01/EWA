package com.yildirimomer01.ewa.data.dto

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class DailyDto(
    @SerialName("time")
    val time: List<String>,
    @SerialName("weathercode")
    val weatherCode: List<Int>,
    @SerialName("temperature_2m_max")
    val temperature2mMax: List<Double?>,
    @SerialName("temperature_2m_min")
    val temperature2mMin: List<Double?>,
    @SerialName("apparent_temperature_max")
    val apparentTemperatureMax: List<Double?>,
    @SerialName("apparent_temperature_min")
    val apparentTemperatureMin: List<Double?>,
    @SerialName("precipitation_sum")
    val precipitationSum: List<Double?>,
    @SerialName("precipitation_probability_max")
    val precipitationProbabilityMax: List<Int?>,
    @SerialName("windspeed_10m_max")
    val windSpeedMax: List<Double?>
)
