package com.yildirimomer01.ewa.data

import com.yildirimomer01.ewa.data.source.network.WeatherService
import com.yildirimomer01.ewa.domain.repository.HomeRepository
import com.yildirimomer01.ewa.util.asResource
import javax.inject.Inject

/**
 * repository class for weather data
 */
class HomeRepositoryImpl @Inject constructor(
    private val weatherService: WeatherService
) : HomeRepository {
    override suspend fun getWeatherInfo(lat: Double, lon: Double) =
        weatherService.getWeatherData(lat, lon).asResource()
}
