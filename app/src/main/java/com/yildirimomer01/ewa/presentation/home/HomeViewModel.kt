package com.yildirimomer01.ewa.presentation.home

import androidx.lifecycle.viewModelScope
import com.yildirimomer01.ewa.domain.model.WeatherInfo
import com.yildirimomer01.ewa.domain.usecase.GetWeatherDataUseCase
import com.yildirimomer01.ewa.presentation.base.BaseViewModel
import com.yildirimomer01.ewa.util.AppDispatcher
import com.yildirimomer01.ewa.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
    private val dispatcher: AppDispatcher
) : BaseViewModel<HomeContract.HomeViewEvent, HomeContract.HomeViewState, HomeContract.HomeViewEffect>() {
    override fun setInitialState() = HomeContract.HomeViewState(isLoading = true)

    private val handler = CoroutineExceptionHandler { _, exception ->
        viewModelScope.launch {
            setState {
                copy(
                    error = Error(exception.message),
                    isLoading = false
                )
            }
        }
        setEffect { HomeContract.HomeViewEffect.OnError }
    }

    init {
        fetchWeatherData()
    }

    fun fetchWeatherData(refresh: Boolean = false) {
        viewModelScope.launch(dispatcher.io + handler) {
            if (refresh) {
                setState {
                    copy(data = null, isLoading = true, error = null)
                }
            }
            getWeatherDataUseCase().collectLatest { result ->
                when (result) {
                    is Resource.Failure -> {
                        setState {
                            copy(
                                data = null,
                                isLoading = false,
                                error = Error(
                                    result.message ?: "Unexpected error while fetching weather info"
                                )
                            )
                        }
                    }

                    is Resource.Success -> result.data?.let {
                        postDataToView(it)
                    }
                }
            }
        }
    }

    private fun postDataToView(data: WeatherInfo) {
        viewModelScope.launch {
            setState {
                copy(
                    data = data,
                    isLoading = false
                )
            }
        }
    }
}
