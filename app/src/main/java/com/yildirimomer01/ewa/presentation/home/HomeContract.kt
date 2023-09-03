package com.yildirimomer01.ewa.presentation.home

import com.yildirimomer01.ewa.domain.model.WeatherModel
import com.yildirimomer01.ewa.presentation.base.ViewEvent
import com.yildirimomer01.ewa.presentation.base.ViewSideEffect
import com.yildirimomer01.ewa.presentation.base.ViewState

class HomeContract {

    sealed interface HomeViewEvent : ViewEvent

    data class HomeViewState(
        val isLoading: Boolean = false,
        val data: WeatherModel? = null,
        val error: Error? = null
    ) : ViewState

    sealed interface HomeViewEffect : ViewSideEffect {
        object OnError : HomeViewEffect
    }
}
