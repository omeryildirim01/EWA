package com.yildirimomer01.ewa.presentation.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.yildirimomer01.ewa.domain.model.FakeWeatherInfo
import com.yildirimomer01.ewa.domain.model.WeatherInfo

class WeatherInfoBoxPreviewParameterProvider : PreviewParameterProvider<WeatherInfo> {
    override val values: Sequence<WeatherInfo>
        get() = sequenceOf(FakeWeatherInfo.getFakeInfo())
}
