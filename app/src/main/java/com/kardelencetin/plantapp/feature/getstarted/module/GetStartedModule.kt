package com.kardelencetin.plantapp.feature.getstarted.module

import com.kardelencetin.plantapp.feature.getstarted.repository.GetStartedRepository
import com.kardelencetin.plantapp.feature.getstarted.repository.GetStartedRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GetStartedModule {

    @Provides
    fun provideGetStartedRepository(): GetStartedRepository {
        return GetStartedRepositoryImpl()
    }
}