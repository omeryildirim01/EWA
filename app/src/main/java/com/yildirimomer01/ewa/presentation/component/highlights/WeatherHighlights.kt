package com.yildirimomer01.ewa.presentation.component.highlights

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yildirimomer01.ewa.R
import com.yildirimomer01.ewa.domain.model.HourlyWeather
import com.yildirimomer01.ewa.domain.model.HourlyWeatherInfo
import com.yildirimomer01.ewa.domain.model.WeatherType
import com.yildirimomer01.ewa.presentation.component.core.VerticalDivider
import java.time.LocalDateTime

@Composable
@Preview(name = "WeatherHighlightsPreview", showBackground = true)
fun WeatherHighlightsPreview() {
    WeatherHighlights(
        state = WeatherHighlightState(
            hourlyWeatherInfo = HourlyWeatherInfo(
                weatherData = listOf(),
                currentWeatherData = HourlyWeather(
                    time = LocalDateTime.now(),
                    temperature = 14,
                    apparentTemperature = 28,
                    weatherType = WeatherType.fromWMO(1),
                    precipitationProbability = 33,
                    windSpeed = 22
                ),
                highTemperature = 30,
                lowTemperature = 35,
                precipitationProbability = 20
            )
        )
    )
}

@Composable
fun WeatherHighlights(state: WeatherHighlightState) {
    state.hourlyWeatherInfo?.let {
        Row(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.weather_high, it.highTemperature)
            )
            VerticalDivider(modifier = Modifier.padding(horizontal = 8.dp))
            Text(
                text = stringResource(id = R.string.weather_low, it.lowTemperature)
            )
            VerticalDivider(modifier = Modifier.padding(horizontal = 8.dp))
            Text(
                text = it.precipitationProbability?.let {
                    stringResource(
                        id = R.string.weather_precipitation,
                        it
                    )
                } ?: stringResource(
                    id = R.string.unknown
                )
            )
        }
    }
}

data class WeatherHighlightState(
    val hourlyWeatherInfo: HourlyWeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
