package com.kardelencetin.plantapp.feature.getstarted.module

import android.content.Context
import com.kardelencetin.plantapp.feature.getstarted.repository.GetStartedRepository
import com.kardelencetin.plantapp.feature.getstarted.repository.GetStartedRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GetStartedModule {

    @Provides
    fun provideGetStartedRepository(
        @ApplicationContext context: Context
    ): GetStartedRepository {
        return GetStartedRepositoryImpl(context)
    }
}