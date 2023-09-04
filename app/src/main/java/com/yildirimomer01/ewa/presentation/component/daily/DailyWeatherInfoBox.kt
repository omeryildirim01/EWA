package com.yildirimomer01.ewa.presentation.component.daily

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yildirimomer01.ewa.R
import com.yildirimomer01.ewa.domain.model.DailyWeather
import com.yildirimomer01.ewa.domain.model.FakeWeatherInfo

@Composable
@Preview(name = "DailyWeatherInfoBoxPreview", showBackground = true)
fun DailyWeatherInfoBoxPreview() {
    DailyWeatherInfoBox(
        uiState = DailyWeatherUIState(
            dailyWeatherData = FakeWeatherInfo.getFakeInfo().dailyWeather
        )
    )
}

@Composable
fun DailyWeatherInfoBox(
    modifier: Modifier = Modifier,
    uiState: DailyWeatherUIState
) {
    uiState.dailyWeatherData?.let { items ->
        Column {
            Text(stringResource(id = R.string.daily_forecast))
            LazyRow(
                modifier = modifier.height(200.dp)
            ) {
                itemsIndexed(items) { _, dailyData ->
                    WeatherDayOverview(
                        dailyWeatherData = dailyData
                    )
                }
            }
        }
    }
}

data class DailyWeatherUIState(
    val dailyWeatherData: List<DailyWeather>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
