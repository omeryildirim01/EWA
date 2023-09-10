package com.yildirimomer01.ewa.presentation.home

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.yildirimomer01.ewa.TestAppDispatcher
import com.yildirimomer01.ewa.domain.model.FakeWeatherInfo
import com.yildirimomer01.ewa.domain.model.WeatherInfo
import com.yildirimomer01.ewa.domain.usecase.GetWeatherDataUseCase
import com.yildirimomer01.ewa.util.AppDispatcher
import com.yildirimomer01.ewa.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private lateinit var testObject: HomeViewModel

    @Mock
    private lateinit var useCase: GetWeatherDataUseCase

    private lateinit var dispatcher: AppDispatcher

    @Before
    fun setUp() {
        dispatcher = TestAppDispatcher()
        Dispatchers.setMain(dispatcher.io)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `on home view model init get weather data returns success with current user location data`() =
        runTest {
            // Arrange
            val fakeInfo = FakeWeatherInfo.getFakeInfo()
            doReturn(flowOf<Resource<WeatherInfo>>(Resource.Success(data = fakeInfo)))
                .`when`(useCase)
                .invoke()
            // Act
            testObject = HomeViewModel(useCase, dispatcher)
            // Assert
            testObject.viewState.test {
                val state = awaitItem()
                assertThat(state.isLoading).isFalse()
                assertThat(state.data).isNotNull()
                assertThat(state.data?.hourlyWeatherInfo?.lowTemperature).isEqualTo(fakeInfo.hourlyWeatherInfo?.lowTemperature)
                assertThat(state.data?.hourlyWeatherInfo?.highTemperature).isEqualTo(fakeInfo.hourlyWeatherInfo?.highTemperature)
            }
            verify(useCase).invoke()
        }

    @Test
    fun `on home view model init get weather data returns error with connection exception`() =
        runTest {
            // Arrange
            doReturn(flowOf<Resource<WeatherInfo>>(Resource.Failure(message = "Connection exception")))
                .`when`(useCase)
                .invoke()
            // Act
            testObject = HomeViewModel(useCase, dispatcher)
            // Assert
            testObject.viewState.test {
                val state = awaitItem()
                assertThat(state.isLoading).isFalse()
                assertThat(state.data).isNull()
                assertThat(state.error?.message).isEqualTo("Connection exception")
            }
            verify(useCase).invoke()
        }

    @Test
    fun `on home view model init get weather data returns error with http exception`() = runTest {
        // Arrange
        doReturn(flowOf<Resource<WeatherInfo>>(Resource.Failure(message = "Http exception")))
            .`when`(useCase)
            .invoke()
        // Act
        testObject = HomeViewModel(useCase, dispatcher)
        // Assert
        testObject.viewState.test {
            val state = awaitItem()
            assertThat(state.isLoading).isFalse()
            assertThat(state.data).isNull()
            assertThat(state.error?.message).isEqualTo("Http exception")
        }
        verify(useCase).invoke()
    }
}
