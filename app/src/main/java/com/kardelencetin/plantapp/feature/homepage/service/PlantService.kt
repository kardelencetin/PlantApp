package com.kardelencetin.plantapp.feature.homepage.service

import com.kardelencetin.plantapp.feature.homepage.model.CategoryResponse
import com.kardelencetin.plantapp.feature.homepage.model.Question
import retrofit2.http.GET

interface PlantService {
    @GET("getCategories")
    suspend fun getCategories(): CategoryResponse

    @GET("getQuestions")
    suspend fun getQuestions(): List<Question>
}