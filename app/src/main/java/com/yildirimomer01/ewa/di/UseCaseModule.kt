package com.yildirimomer01.ewa.di

import com.yildirimomer01.ewa.domain.repository.HomeRepository
import com.yildirimomer01.ewa.domain.usecase.GetWeatherDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetWeatherUseCase(
        repository: HomeRepository
    ): GetWeatherDataUseCase = GetWeatherDataUseCase(repository)
}
