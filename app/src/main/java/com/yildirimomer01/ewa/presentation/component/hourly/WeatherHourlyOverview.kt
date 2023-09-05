package com.yildirimomer01.ewa.presentation.component.hourly

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yildirimomer01.ewa.domain.model.HourlyWeather
import com.yildirimomer01.ewa.domain.model.WeatherType
import com.yildirimomer01.ewa.presentation.component.core.LabelText
import com.yildirimomer01.ewa.presentation.component.core.TemperatureText
import com.yildirimomer01.ewa.presentation.component.core.WHOCard
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
    modifier: Modifier = Modifier,
    hourlyWeather: HourlyWeather
) {
    WHOCard(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth(),
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
                    LabelText(text = formattedTime)
                    Image(
                        painter = painterResource(id = it.weatherType.iconRes),
                        contentDescription = "Image of ${stringResource(id = it.weatherType.descriptionRes)}",
                        modifier = Modifier.width(32.dp)
                    )
                    TemperatureText(temperature = it.temperature)
                }
            }
        }
    }
}
