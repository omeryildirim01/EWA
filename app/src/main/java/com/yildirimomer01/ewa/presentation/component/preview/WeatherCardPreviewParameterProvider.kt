package com.yildirimomer01.ewa.presentation.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.yildirimomer01.ewa.domain.model.FakeWeatherInfo
import com.yildirimomer01.ewa.domain.model.HourlyWeather

class WeatherCardPreviewParameterProvider : PreviewParameterProvider<HourlyWeather> {
    override val values: Sequence<HourlyWeather>
        get() = sequenceOf(FakeWeatherInfo.getHourlyWeather())
}
