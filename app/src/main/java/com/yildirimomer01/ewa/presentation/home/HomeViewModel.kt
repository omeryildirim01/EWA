package com.yildirimomer01.ewa.presentation.home

import androidx.lifecycle.viewModelScope
import com.yildirimomer01.ewa.domain.model.WeatherInfo
import com.yildirimomer01.ewa.domain.usecase.GetWeatherDataUseCase
import com.yildirimomer01.ewa.presentation.base.BaseViewModel
import com.yildirimomer01.ewa.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase
) : BaseViewModel<HomeContract.HomeViewEvent, HomeContract.HomeViewState, HomeContract.HomeViewEffect>() {
    override fun setInitialState() = HomeContract.HomeViewState(isLoading = true)

    init {
        fetchWeatherData()
    }

    private fun fetchWeatherData() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            getWeatherDataUseCase().collectLatest { result ->
                when (result) {
                    is Resource.Failure -> {
                        setState {
                            copy(
                                data = null,
                                isLoading = false,
                                error = Error("Unexpected error while fetching weather info")
                            )
                        }
                    }
                    is Resource.Success -> result.data?.let {
                        updatePostsDataToView(it)
                    }
                }
            }
        }
    }
    private fun updatePostsDataToView(data: WeatherInfo) {
        viewModelScope.launch {
            setState {
                copy(
                    data = data,
                    isLoading = false
                )
            }
        }
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        viewModelScope.launch {
            setState {
                copy(
                    error = Error(throwable.localizedMessage),
                    isLoading = false
                )
            }
        }
        setEffect { HomeContract.HomeViewEffect.OnError }
    }
}
