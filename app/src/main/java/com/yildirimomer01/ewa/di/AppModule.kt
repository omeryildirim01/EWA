package com.yildirimomer01.ewa.di

import com.yildirimomer01.ewa.util.AppDispatcher
import com.yildirimomer01.ewa.util.AssetManager
import com.yildirimomer01.ewa.util.AssetManagerImpl
import com.yildirimomer01.ewa.util.DefaultAppDispatcher
import com.yildirimomer01.ewa.util.MockResponseManager
import com.yildirimomer01.ewa.util.MockResponseManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAssetManager(): AssetManager = AssetManagerImpl()

    @Provides
    fun provideResponseManager(): MockResponseManager = MockResponseManagerImpl()

    @Provides
    fun provideDispatcher(): AppDispatcher = DefaultAppDispatcher()
}
