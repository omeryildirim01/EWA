package com.yildirimomer01.ewa.domain.usecase

import com.yildirimomer01.ewa.domain.mappers.toWeatherInfo
import com.yildirimomer01.ewa.domain.model.WeatherInfo
import com.yildirimomer01.ewa.domain.repository.HomeRepository
import com.yildirimomer01.ewa.util.Constants.LAT
import com.yildirimomer01.ewa.util.Constants.LON
import com.yildirimomer01.ewa.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * class that fetches weather info by using geolocation info lat/long
 */
class GetWeatherDataUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    operator fun invoke(lat: Double = LAT, lon: Double = LON): Flow<Resource<WeatherInfo>> {
        return flow {
            repository.getWeatherInfo(lat = lat, lon = lon).data?.let {
                emit(Resource.Success(it.toWeatherInfo()))
            } ?: kotlin.run {
                emit(Resource.Failure(message = "Unknown Exception"))
            }
        }
    }
}
