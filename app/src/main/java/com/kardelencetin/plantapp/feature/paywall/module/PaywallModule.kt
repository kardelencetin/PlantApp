package com.kardelencetin.plantapp.feature.paywall.module

import com.kardelencetin.plantapp.feature.paywall.repository.PaywallRepository
import com.kardelencetin.plantapp.feature.paywall.repository.PaywallRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PaywallModule {

    @Provides
    fun providePaywallRepository(): PaywallRepository {
        return PaywallRepositoryImpl()
    }
}