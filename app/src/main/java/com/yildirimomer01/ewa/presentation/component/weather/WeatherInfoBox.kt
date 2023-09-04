package com.yildirimomer01.ewa.presentation.component.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.yildirimomer01.ewa.R
import com.yildirimomer01.ewa.domain.model.WeatherInfo
import com.yildirimomer01.ewa.presentation.component.daily.DailyWeatherInfoBox
import com.yildirimomer01.ewa.presentation.component.daily.DailyWeatherUIState
import com.yildirimomer01.ewa.presentation.component.highlights.WeatherHighlightState
import com.yildirimomer01.ewa.presentation.component.highlights.WeatherHighlights
import com.yildirimomer01.ewa.presentation.component.hourly.HourlyWeatherInfoBox
import com.yildirimomer01.ewa.presentation.component.hourly.HourlyWeatherUIState
import com.yildirimomer01.ewa.presentation.component.preview.WeatherInfoBoxPreviewParameterProvider

@Preview(name = "WeatherInfoBoxPreview", showBackground = true)
@Composable
fun WeatherInfoBoxPreview(
    @PreviewParameter(WeatherInfoBoxPreviewParameterProvider::class) info: WeatherInfo
) {
    WeatherInfoBox(info)
}

@Composable
fun WeatherInfoBox(
    info: WeatherInfo
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .testTag(stringResource(id = R.string.weather_info_tag))
        ) {
            LazyColumn {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    WeatherCard(hour = info.hourlyWeatherInfo?.currentWeatherData)
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                    )
                }

                item {
                    WeatherHighlights(
                        state = WeatherHighlightState(
                            hourlyWeatherInfo = info.hourlyWeatherInfo
                        )
                    )
                }

                item {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    HourlyWeatherInfoBox(
                        uiState = HourlyWeatherUIState(
                            hourlyWeatherData = info.hourlyWeather
                        )
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    DailyWeatherInfoBox(
                        uiState = DailyWeatherUIState(
                            dailyWeatherData = info.dailyWeather
                        )
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
