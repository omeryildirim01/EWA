package com.yildirimomer01.ewa.domain.usecase

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.yildirimomer01.ewa.ResourceFileHelper
import com.yildirimomer01.ewa.data.dto.WeatherWrapperDto
import com.yildirimomer01.ewa.domain.mappers.toWeatherInfo
import com.yildirimomer01.ewa.domain.model.WeatherInfo
import com.yildirimomer01.ewa.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.serialization.json.decodeFromStream
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any

class GetWeatherDataUseCaseTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @Mock
    lateinit var testObject: GetWeatherDataUseCase

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cancel()
    }

    @Test
    fun `get weather data with success response`() = runTest {
        // Arrange
        val testDataStream = GetWeatherDataUseCaseTest::class.java.getResourceAsStream("/weather.json")
        val testData = ResourceFileHelper.json().decodeFromStream<WeatherWrapperDto>(testDataStream).toWeatherInfo()
        val flowData = flow<Resource<WeatherInfo>> {
            emit(Resource.Success(null))
            emit(Resource.Success(testData))
        }
        // Act
        Mockito.`when`(testObject.invoke(any(), any())).thenReturn(flowData)
        // Assert
        testObject.invoke(any(), any()).test {
            assertThat(awaitItem()).isInstanceOf(Resource.Success::class.java)
            val flowData = awaitItem().data
            assertThat(flowData).isNotNull()
            assertThat(flowData?.hourlyWeatherInfo?.highTemperature).isEqualTo(testData.hourlyWeatherInfo?.highTemperature)
            assertThat(flowData?.hourlyWeatherInfo?.lowTemperature).isEqualTo(testData.hourlyWeatherInfo?.lowTemperature)
            awaitComplete()
        }
    }

    @Test
    fun `get failure result with error message`() = runTest {
        // Arrange
        val flowData = flow<Resource<WeatherInfo>> {
            emit(Resource.Failure(message = "Unknown Exception", data = null))
        }
        // Act
        Mockito.`when`(testObject.invoke(any(), any())).thenReturn(flowData)
        // Assert
        testObject.invoke(any(), any()).test {
            val failureResult = awaitItem()
            assertThat(failureResult).isInstanceOf(Resource.Failure::class.java)
            assertThat(failureResult.data).isNull()
            assertThat(failureResult.message).isNotNull()
            assertThat(failureResult.message).isEqualTo("Unknown Exception")
            awaitComplete()
        }
    }
}
