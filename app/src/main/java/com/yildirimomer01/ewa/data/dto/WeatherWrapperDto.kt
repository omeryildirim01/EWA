package com.yildirimomer01.ewa.data.dto

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class WeatherWrapperDto(
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double,
    @SerialName("hourly")
    val hourlyDto: HourlyDto,
    @SerialName("daily")
    val dailyDto: DailyDto
)
