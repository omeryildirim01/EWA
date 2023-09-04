package com.yildirimomer01.ewa.presentation.home

import com.yildirimomer01.ewa.domain.model.WeatherInfo
import com.yildirimomer01.ewa.presentation.base.ViewEvent
import com.yildirimomer01.ewa.presentation.base.ViewSideEffect
import com.yildirimomer01.ewa.presentation.base.ViewState

class HomeContract {

    sealed interface HomeViewEvent : ViewEvent

    data class HomeViewState(
        val isLoading: Boolean = false,
        val data: WeatherInfo? = null,
        val error: Error? = null
    ) : ViewState

    sealed interface HomeViewEffect : ViewSideEffect {
        data object OnError : HomeViewEffect
    }
}
