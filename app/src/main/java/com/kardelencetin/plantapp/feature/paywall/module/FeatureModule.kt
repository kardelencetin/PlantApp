package com.kardelencetin.plantapp.feature.paywall.module

import com.kardelencetin.plantapp.feature.paywall.repository.FeatureRepository
import com.kardelencetin.plantapp.feature.paywall.repository.FeatureRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FeatureModule {
    @Provides
    fun provideFeatureRepository(): FeatureRepository {
        return FeatureRepositoryImpl()
    }
}