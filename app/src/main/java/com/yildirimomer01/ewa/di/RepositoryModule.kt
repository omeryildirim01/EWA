package com.yildirimomer01.ewa.di

import com.yildirimomer01.ewa.data.HomeRepositoryImpl
import com.yildirimomer01.ewa.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun binHomeRepository(homeRepository: HomeRepositoryImpl): HomeRepository
}
