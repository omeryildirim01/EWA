package com.yildirimomer01.ewa.presentation.component.today

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yildirimomer01.ewa.R

@Preview(name = "TodayWeatherImagePreview", showBackground = true)
@Composable
fun TodayWeatherImagePreview() {
    TodayWeatherImage(
        state = TodayWeatherImageUIState(
            weatherTypeIconRes = R.drawable.ic_cloudy,
            weatherDescription = R.string.clear_sky,
            imageHeight = 96.dp,
            temperature = 20,
            tempFontSize = 44,
            weatherDescFontSize = 20,
            spacerHeight = 12.dp
        )
    )
}

@Composable
fun TodayWeatherImage(
    modifier: Modifier = Modifier,
    state: TodayWeatherImageUIState
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(state.spacerHeight))
        Image(
            painter = painterResource(id = state.weatherTypeIconRes),
            contentDescription = "Image of ${stringResource(id = state.weatherDescription)}",
            modifier = Modifier.height(state.imageHeight)
        )
        Spacer(modifier = Modifier.height(state.spacerHeight))
        Text(text = "${state.temperature}°C", fontSize = state.tempFontSize.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = state.weatherDescription),
            fontSize = 24.sp,
            maxLines = 2
        )
    }
}

data class TodayWeatherImageUIState(
    @DrawableRes val weatherTypeIconRes: Int,
    @StringRes val weatherDescription: Int,
    val imageHeight: Dp = 96.dp,
    val temperature: Int? = 0,
    val tempFontSize: Int = 44,
    val weatherDescFontSize: Int = 20,
    val spacerHeight: Dp = 12.dp
)
