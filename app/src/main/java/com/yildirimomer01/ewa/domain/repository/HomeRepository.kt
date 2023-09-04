package com.yildirimomer01.ewa.domain.repository

import com.yildirimomer01.ewa.data.dto.WeatherWrapperDto
import com.yildirimomer01.ewa.util.Resource

interface HomeRepository {
    suspend fun getWeatherInfo(
        lat: Double,
        lon: Double
    ): Resource<WeatherWrapperDto>
}
