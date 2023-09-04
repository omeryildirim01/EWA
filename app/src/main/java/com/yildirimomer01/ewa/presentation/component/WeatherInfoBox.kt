package com.yildirimomer01.ewa.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.yildirimomer01.ewa.R
import com.yildirimomer01.ewa.domain.model.WeatherInfo

@Composable
fun WeatherInfoBox(
    info: WeatherInfo
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag(stringResource(id = R.string.weather_info_tag))
    ) {
        Text(text = "Hello world")
        Text(text = "Data is ready!")
    }
}
