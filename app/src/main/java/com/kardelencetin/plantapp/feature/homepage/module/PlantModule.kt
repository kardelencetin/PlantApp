package com.kardelencetin.plantapp.feature.homepage.module

import android.content.Context
import androidx.room.Room
import com.kardelencetin.plantapp.feature.homepage.repository.CategoryRepository
import com.kardelencetin.plantapp.feature.homepage.repository.QuestionRepository
import com.kardelencetin.plantapp.feature.homepage.roomdb.dao.CategoryDao
import com.kardelencetin.plantapp.feature.homepage.roomdb.dao.QuestionDao
import com.kardelencetin.plantapp.feature.homepage.roomdb.database.PlantDatabase
import com.kardelencetin.plantapp.feature.homepage.service.PlantService
import com.kardelencetin.plantapp.feature.homepage.usecase.CategoryUseCase
import com.kardelencetin.plantapp.feature.homepage.usecase.QuestionUseCase
import com.kardelencetin.plantapp.feature.homepage.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object PlantModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PlantDatabase {
        return Room.databaseBuilder(
            context,
            PlantDatabase::class.java,
            "plant_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideCategoryDao(database: PlantDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    fun provideQuestionDao(database: PlantDatabase): QuestionDao {
        return database.questionDao()
    }

    @Provides
    fun provideApiService(): PlantService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlantService::class.java)
    }

    @Provides
    fun provideCategoryRepository(
        apiService: PlantService,
        categoryDao: CategoryDao
    ): CategoryRepository {
        return CategoryRepository(apiService, categoryDao)
    }

    @Provides
    fun provideQuestionRepository(
        apiService: PlantService,
        questionDao: QuestionDao
    ): QuestionRepository {
        return QuestionRepository(apiService, questionDao)
    }

    @Provides
    fun provideCategoryUseCase(
        repository: CategoryRepository
    ): CategoryUseCase {
        return CategoryUseCase(repository)
    }

    @Provides
    fun provideQuestionUseCase(
        repository: QuestionRepository
    ): QuestionUseCase {
        return QuestionUseCase(repository)
    }
}