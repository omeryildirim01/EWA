package com.yildirimomer01.ewa.presentation.component.daily

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yildirimomer01.ewa.domain.model.DailyWeather
import com.yildirimomer01.ewa.domain.model.WeatherType
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
@Preview(name = "WeatherDayOverviewPreview", showBackground = true)
fun WeatherDayOverviewPreview() {
    WeatherDayOverview(
        dailyWeatherData = DailyWeather(
            date = LocalDate.now(),
            weatherType = WeatherType.fromWMO(1),
            temperatureMax = 15,
            temperatureMin = 12,
            apparentTemperatureMax = 33,
            apparentTemperatureMin = 23,
            precipitationProbabilityMax = null,
            windSpeedMax = 20
        )
    )
}

@Composable
fun WeatherDayOverview(
    modifier: Modifier = Modifier,
    dailyWeatherData: DailyWeather
) {
    val formattedDate = dailyWeatherData.date.format(DateTimeFormatter.ofPattern("E d"))
    Card(
        border = BorderStroke(1.dp, Color.Cyan),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = modifier
            .padding(
                horizontal = 8.dp,
                vertical = 16.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = formattedDate)
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = dailyWeatherData.weatherType.iconRes),
                contentDescription = "Image of ${stringResource(id = dailyWeatherData.weatherType.descriptionRes)}",
                modifier = Modifier.width(48.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${dailyWeatherData.temperatureMax}°C",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}
