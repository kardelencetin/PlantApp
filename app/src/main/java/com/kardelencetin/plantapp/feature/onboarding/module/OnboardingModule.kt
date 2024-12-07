package com.kardelencetin.plantapp.feature.onboarding.module

import com.kardelencetin.plantapp.feature.onboarding.repository.OnboardingRepository
import com.kardelencetin.plantapp.feature.onboarding.repository.OnboardingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object OnboardingModule {

    @Provides
    fun provideOnboardingRepository(): OnboardingRepository {
        return OnboardingRepositoryImpl()
    }
}