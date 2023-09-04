package com.yildirimomer01.ewa.presentation.home

import com.yildirimomer01.ewa.domain.model.WeatherInfo

data class HomeContentUIState(
    val uiData: WeatherInfo? = null,
    val onAction: () -> Unit?,
    val error: Error? = null
)
