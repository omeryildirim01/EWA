package com.yildirimomer01.ewa.domain.model

import java.time.LocalDate
import java.time.LocalDateTime

object FakeWeatherInfo {

    fun getHourlyWeather() = HourlyWeather(
        time = LocalDateTime.now(),
        temperature = 22,
        apparentTemperature = 33,
        weatherType = WeatherType.fromWMO(1),
        precipitationProbability = 33,
        windSpeed = 62
    )

    fun getFakeInfo() = WeatherInfo(
        dailyWeather = listOf(
            DailyWeather(
                date = LocalDate.now(),
                weatherType = WeatherType.fromWMO(1),
                temperatureMax = 77,
                temperatureMin = 53,
                apparentTemperatureMax = 32,
                apparentTemperatureMin = 30,
                precipitationProbabilityMax = 20,
                windSpeedMax = 44
            ),
            DailyWeather(
                date = LocalDate.now(),
                weatherType = WeatherType.fromWMO(1),
                temperatureMax = 77,
                temperatureMin = 53,
                apparentTemperatureMax = 75,
                apparentTemperatureMin = 29,
                precipitationProbabilityMax = 20,
                windSpeedMax = 46
            ),
            DailyWeather(
                date = LocalDate.now(),
                weatherType = WeatherType.fromWMO(1),
                temperatureMax = 32,
                temperatureMin = 10,
                apparentTemperatureMax = 4,
                apparentTemperatureMin = 9,
                precipitationProbabilityMax = 20,
                windSpeedMax = 4
            ),
            DailyWeather(
                date = LocalDate.now(),
                weatherType = WeatherType.fromWMO(1),
                temperatureMax = 32,
                temperatureMin = 10,
                apparentTemperatureMax = 4,
                apparentTemperatureMin = 9,
                precipitationProbabilityMax = 20,
                windSpeedMax = 4
            )
        ),
        hourlyWeatherInfo = HourlyWeatherInfo(
            weatherData = listOf(
                HourlyWeather(
                    time = LocalDateTime.now(),
                    temperature = 7,
                    apparentTemperature = 1,
                    weatherType = WeatherType.fromWMO(1),
                    precipitationProbability = 8,
                    windSpeed = 13
                ),
                HourlyWeather(
                    time = LocalDateTime.now(),
                    temperature = 7,
                    apparentTemperature = 1,
                    weatherType = WeatherType.fromWMO(1),
                    precipitationProbability = 8,
                    windSpeed = 13
                ),
                HourlyWeather(
                    time = LocalDateTime.now(),
                    temperature = 7,
                    apparentTemperature = 1,
                    weatherType = WeatherType.fromWMO(1),
                    precipitationProbability = 8,
                    windSpeed = 13
                )
            ),
            currentWeatherData = HourlyWeather(
                time = LocalDateTime.now(),
                temperature = 7,
                apparentTemperature = 1,
                weatherType = WeatherType.fromWMO(1),
                precipitationProbability = 8,
                windSpeed = 13
            ),
            highTemperature = 8678,
            lowTemperature = 2640,
            precipitationProbability = 40

        ),
        hourlyWeather = listOf(
            HourlyWeather(
                time = LocalDateTime.now(),
                temperature = 6,
                apparentTemperature = 1,
                weatherType = WeatherType.fromWMO(1),
                precipitationProbability = 20,
                windSpeed = 13
            ),
            HourlyWeather(
                time = LocalDateTime.now(),
                temperature = 6,
                apparentTemperature = 7,
                weatherType = WeatherType.fromWMO(1),
                precipitationProbability = 20,
                windSpeed = 13
            ),
            HourlyWeather(
                time = LocalDateTime.now(),
                temperature = 6,
                apparentTemperature = 21,
                weatherType = WeatherType.fromWMO(1),
                precipitationProbability = 20,
                windSpeed = 9
            )
        )
    )
}
