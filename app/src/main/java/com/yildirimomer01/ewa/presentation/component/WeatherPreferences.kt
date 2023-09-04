package com.yildirimomer01.ewa.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yildirimomer01.ewa.R

@Composable
fun WeatherInfoPreferences(
    modifier: Modifier = Modifier,
    apparentTemperature: Int? = 0,
    precipitationProbability: Int? = 0,
    windSpeed: Int? = 0
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        WeatherInfoRow(
            value = apparentTemperature,
            unit = "°C",
            icon = R.drawable.ic_thermostat_24,
            description = R.string.feels_like,
            top = 4.dp
        )
        WeatherInfoRow(
            value = precipitationProbability,
            unit = "%",
            icon = R.drawable.ic_water_drop_24,
            description = R.string.chance_of_precipitation,
            top = 24.dp
        )
        WeatherInfoRow(
            value = windSpeed,
            unit = "km/h",
            icon = R.drawable.ic_wind_24,
            description = R.string.wind_speed,
            top = 4.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherInfoPreferencesPreview() {
    WeatherInfoPreferences(
        apparentTemperature = 20,
        precipitationProbability = 30,
        windSpeed = 40
    )
}
