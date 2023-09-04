package com.yildirimomer01.ewa.presentation.component.hourly

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yildirimomer01.ewa.domain.model.HourlyWeather
import com.yildirimomer01.ewa.domain.model.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
@Preview(name = "WeatherHourlyOverviewPreview", showBackground = true)
fun WeatherHourlyOverviewPreview() {
    WeatherHourlyOverview(
        hourlyWeather = HourlyWeather(
            time = LocalDateTime.now(),
            temperature = 19,
            apparentTemperature = 20,
            weatherType = WeatherType.fromWMO(1),
            precipitationProbability = 20,
            windSpeed = 12
        )
    )
}

@Composable
fun WeatherHourlyOverview(
    hourlyWeather: HourlyWeather
) {
    Card(
        border = BorderStroke(1.dp, Color.Cyan),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .clip(RoundedCornerShape(26))
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .height(120.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            hourlyWeather.let {
                val formattedTime = it.time.format(DateTimeFormatter.ofPattern("HH:mm"))
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = formattedTime)
                    Image(
                        painter = painterResource(id = it.weatherType.iconRes),
                        contentDescription = "Image of ${stringResource(id = it.weatherType.descriptionRes)}",
                        modifier = Modifier.width(32.dp)
                    )
                    Text(text = "${it.temperature}°C")
                }
            }
        }
    }
}
