package com.yildirimomer01.ewa.data.source.network

import com.google.common.truth.Truth.assertThat
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.yildirimomer01.ewa.ResourceFileHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

@OptIn(ExperimentalCoroutinesApi::class)
class WeatherServiceTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private val client = OkHttpClient.Builder().build()
    private lateinit var mockWebServer: MockWebServer
    private lateinit var weatherService: WeatherService
    private val json = Json { ignoreUnknownKeys = true }
    private val contentType = "application/json".toMediaType()
    private val lat = 41.0
    private val lon = 28.9375

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        mockWebServer = MockWebServer()
        weatherService = Retrofit
            .Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(client)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(WeatherService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
        Dispatchers.resetMain()
    }

    @Test
    fun `get weather data request returns mock weather response info`() = runTest {
        // Arrange
        val body = ResourceFileHelper.readFileResource("/weather.json")
        val mockResponse = MockResponse()
            .setBody(body)
            .setResponseCode(200)
        mockWebServer.enqueue(mockResponse)
        // Act
        val serviceResponse = weatherService.getWeatherData(lat = lat, lon = lon)
        mockWebServer.takeRequest()
        val responseData = serviceResponse.body()
        // Assert
        assertThat(serviceResponse.body().toString()).isNotEmpty()
        assertThat(responseData).isNotNull()
        assertThat(responseData?.latitude).isEqualTo(lat)
        assertThat(responseData?.longitude).isEqualTo(lon)
    }
}
