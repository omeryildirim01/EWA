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
import com.yildirimomer01.ewa.presentation.component.core.EWAHorizontalDivider
import com.yildirimomer01.ewa.presentation.component.core.EWAHorizontalSpacer
import com.yildirimomer01.ewa.presentation.component.core.EWALazyRow
import com.yildirimomer01.ewa.presentation.component.core.EWALazyRowData
import com.yildirimomer01.ewa.presentation.component.daily.DailyWeatherInfoBox
import com.yildirimomer01.ewa.presentation.component.daily.DailyWeatherUIState
import com.yildirimomer01.ewa.presentation.component.highlights.WeatherHighlightState
import com.yildirimomer01.ewa.presentation.component.highlights.WeatherHighlights
import com.yildirimomer01.ewa.presentation.component.hourly.WeatherHourlyOverview
import com.yildirimomer01.ewa.presentation.component.preview.WeatherInfoBoxPreviewParameterProvider

@Preview(name = "WeatherInfoBoxPreview", showBackground = true)
@Composable
fun WeatherInfoBoxPreview(
    @PreviewParameter(WeatherInfoBoxPreviewParameterProvider::class) info: WeatherInfo
) {
    WeatherInfoBox(
        info = info
    )
}

@Composable
fun WeatherInfoBox(
    modifier: Modifier = Modifier,
    info: WeatherInfo
) {
    Box(
        modifier = modifier
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
                // spacing
                item {
                    EWAHorizontalSpacer()
                }
                // Top section :  WeatherCard
                item {
                    WeatherCard(hour = info.hourlyWeatherInfo?.currentWeatherData)
                }
                // divider
                item {
                    Column {
                        EWAHorizontalSpacer()
                        EWAHorizontalDivider()
                    }
                }

                // Highlights for today
                item {
                    WeatherHighlights(
                        state = WeatherHighlightState(
                            hourlyWeatherInfo = info.hourlyWeatherInfo
                        )
                    )
                }
                // divider
                item {
                    Column {
                        EWAHorizontalDivider()
                        EWAHorizontalSpacer()
                    }
                }
                // hourly info boxes
                info.hourlyWeather.map { hourlyItem ->
                    EWALazyRowData(
                        item = hourlyItem,
                        content = {
                            WeatherHourlyOverview(
                                hourlyWeather = hourlyItem
                            )
                        }
                    )
                }.let { hours ->
                    item {
                        EWALazyRow(items = hours)
                    }
                }
                // spacer
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
                // daily info boxes
                item {
                    DailyWeatherInfoBox(
                        uiState = DailyWeatherUIState(
                            dailyWeatherData = info.dailyWeather
                        )
                    )
                }
                // spacer
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
