package com.yildirimomer01.ewa.presentation.component.hourly

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.yildirimomer01.ewa.R
import com.yildirimomer01.ewa.domain.model.HourlyWeather

@Composable
fun HourlyWeatherInfoBox(
    modifier: Modifier = Modifier,
    uiState: HourlyWeatherUIState
) {
    uiState.hourlyWeatherData?.let { items ->
        Column {
            Text(stringResource(id = R.string.hourly_weather_forecast))
            LazyRow(
                modifier = modifier
            ) {
                itemsIndexed(items) { _, hourly ->
                    WeatherHourlyOverview(
                        hourlyWeather = hourly
                    )
                }
            }
        }
    }
}

data class HourlyWeatherUIState(
    val hourlyWeatherData: List<HourlyWeather>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
