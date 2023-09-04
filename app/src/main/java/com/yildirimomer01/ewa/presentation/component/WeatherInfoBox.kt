package com.yildirimomer01.ewa.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.yildirimomer01.ewa.R
import com.yildirimomer01.ewa.domain.model.WeatherInfo
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
            .clip(
                RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)
            )
            .background(Color.Red)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .testTag(stringResource(id = R.string.weather_info_tag))
        ) {
            WeatherCard(hour = info.hourlyWeatherInfo?.currentWeatherData)
        }
    }
}
