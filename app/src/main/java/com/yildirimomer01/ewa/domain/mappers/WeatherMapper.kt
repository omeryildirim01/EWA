package com.yildirimomer01.ewa.domain.mappers

import com.yildirimomer01.ewa.data.dto.DailyDto
import com.yildirimomer01.ewa.data.dto.HourlyDto
import com.yildirimomer01.ewa.data.dto.WeatherWrapperDto
import com.yildirimomer01.ewa.domain.model.DailyWeather
import com.yildirimomer01.ewa.domain.model.HourlyWeather
import com.yildirimomer01.ewa.domain.model.HourlyWeatherInfo
import com.yildirimomer01.ewa.domain.model.WeatherInfo
import com.yildirimomer01.ewa.domain.model.WeatherType
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

fun HourlyDto.toHourlyWeatherData(): List<HourlyWeather> {
    return time.subList(0, 24).mapIndexed { index, time ->
        HourlyWeather(
            time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
            temperature = temperature[index].roundToInt(),
            apparentTemperature = apparentTemperature[index].roundToInt(),
            windSpeed = windSpeed[index].roundToInt(),
            precipitationProbability = precipitationProbability.getOrNull(index),
            weatherType = WeatherType.fromWMO(weatherCode[index])
        )
    }
}

fun DailyDto.toDailyWeatherData(): List<DailyWeather> {
    return time.mapIndexed { index, date ->
        DailyWeather(
            date = LocalDate.parse(date, DateTimeFormatter.ISO_DATE),
            weatherType = WeatherType.fromWMO(weatherCode[index]),
            apparentTemperatureMax = apparentTemperatureMax[index].roundToInt(),
            apparentTemperatureMin = apparentTemperatureMin[index].roundToInt(),
            temperatureMax = temperature2mMax[index].roundToInt(),
            temperatureMin = temperature2mMin[index].roundToInt(),
            precipitationProbabilityMax = precipitationProbabilityMax.getOrNull(index),
            windSpeedMax = windSpeedMax[index].roundToInt()
        )
    }
}

fun WeatherWrapperDto.toHourlyWeatherInfo(): HourlyWeatherInfo {
    val weatherDataMap = hourlyDto.toHourlyWeatherData()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap.find {
        it.time.hour == now.hour
    }
    return HourlyWeatherInfo(
        weatherData = weatherDataMap,
        currentWeatherData = currentWeatherData,
        highTemperature = weatherDataMap.maxBy { it.temperature }.temperature,
        lowTemperature = weatherDataMap.minBy { it.temperature }.temperature,
        precipitationProbability = weatherDataMap.maxBy { it.precipitationProbability ?: 0 }.precipitationProbability
    )
}

fun WeatherWrapperDto.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        dailyWeather = this.dailyDto.toDailyWeatherData(),
        hourlyWeatherInfo = this.toHourlyWeatherInfo(),
        hourlyWeather = this.hourlyDto.toHourlyWeatherData()
    )
}
