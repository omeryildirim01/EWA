package com.yildirimomer01.ewa.di

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.yildirimomer01.ewa.data.source.network.WeatherService
import com.yildirimomer01.ewa.util.Constants.BASE_URL
import com.yildirimomer01.ewa.util.MockInterceptor
import com.yildirimomer01.ewa.util.MockResponseManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideJson() = Json { ignoreUnknownKeys = true }

    @Provides
    fun provideMockInterceptor(
        @ApplicationContext context: Context,
        mockResponseManager: MockResponseManager
    ): MockInterceptor {
        return MockInterceptor(context, mockResponseManager)
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        mockInterceptor: MockInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(mockInterceptor)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        json: Json
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    private val contentType = "application/json".toMediaType()

    @Provides
    @Singleton
    fun provideWeatherService(
        retrofit: Retrofit
    ): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }
}
