package com.yildirimomer01.ewa.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.yildirimomer01.ewa.domain.model.HourlyWeather
import com.yildirimomer01.ewa.presentation.component.preview.WeatherCardPreviewParameterProvider
import com.yildirimomer01.ewa.presentation.theme.backgroundColor

@Preview(name = "WeatherCardPreview", showBackground = true)
@Composable
fun WeatherCardPreview(
    @PreviewParameter(WeatherCardPreviewParameterProvider::class) weather: HourlyWeather
) {
    WeatherCard(weather)
}

@Composable
fun WeatherCard(hour: HourlyWeather?, modifier: Modifier = Modifier) {
    hour?.let {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .drawAnimatedBorder(
                    strokeWidth = 6.dp,
                    durationMillis = 3000,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = modifier.padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(CircleShape)
                        .background(backgroundColor)
                        .padding(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TodayLabel(localDateTime = it.time)
                    TodayWeatherImage(
                        state = TodayWeatherImageUIState(
                            weatherTypeIconRes = it.weatherType.iconRes,
                            weatherDescription = it.weatherType.descriptionRes,
                            temperature = it.temperature
                        )
                    )
                    WeatherInfoPreferences(
                        apparentTemperature = it.apparentTemperature,
                        precipitationProbability = it.precipitationProbability,
                        windSpeed = it.windSpeed
                    )
                }
            }
        }
    }
}
