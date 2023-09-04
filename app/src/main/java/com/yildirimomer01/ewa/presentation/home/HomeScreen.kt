@file:JvmName("HomeScreenKt")

package com.yildirimomer01.ewa.presentation.home

import androidx.compose.runtime.Composable
import com.yildirimomer01.ewa.presentation.component.core.ErrorBox
import com.yildirimomer01.ewa.presentation.component.core.LoadingBar
import com.yildirimomer01.ewa.presentation.component.weather.WeatherInfoBox

@Composable
fun HomeScreen(
    viewState: HomeContract.HomeViewState
) {
    if (viewState.isLoading) {
        LoadingBar()
    } else if (viewState.data != null) {
        WeatherInfoBox(info = viewState.data)
    } else {
        ErrorBox()
    }
}
