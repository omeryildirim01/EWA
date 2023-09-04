package com.yildirimomer01.ewa.data.dto

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class DailyUnitsDto(
    @SerialName("time")
    val time: String,
    @SerialName("weatherCode")
    val weatherCode: String?,
    @SerialName("temperature_2m_max")
    val temperature2mMax: String?,
    @SerialName("temperature_2m_min")
    val temperature2mMin: String?,
    @SerialName("apparent_temperature_max")
    val apparentTemperatureMax: String?,
    @SerialName("apparent_temperature_min")
    val apparentTemperatureMin: String?,
    @SerialName("precipitation_sum")
    val precipitationSum: String?,
    @SerialName("precipitation_probability_max")
    val precipitationProbabilityMax: String?,
    @SerialName("windSpeed_10m_max")
    val windSpeed10mMax: String?
)
