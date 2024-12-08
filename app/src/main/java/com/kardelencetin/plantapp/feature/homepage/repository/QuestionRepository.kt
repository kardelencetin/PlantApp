package com.kardelencetin.plantapp.feature.homepage.repository

import com.kardelencetin.plantapp.feature.homepage.roomdb.dao.QuestionDao
import com.kardelencetin.plantapp.feature.homepage.roomdb.database.PlantDatabase
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.QuestionEntity
import com.kardelencetin.plantapp.feature.homepage.service.PlantService
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: PlantService,
    private val questionDao: QuestionDao
) {
    suspend fun getQuestions(): List<QuestionEntity> {
        val cachedQuestions = questionDao.getAllQuestions()

        if (cachedQuestions.isNotEmpty() && !isDataStale(cachedQuestions)) {
            return cachedQuestions
        }

        return try {
            val questions = api.getQuestions().map { dto ->
                QuestionEntity(
                    id = dto.id,
                    title = dto.title,
                    subtitle = dto.subtitle,
                    imageUri = dto.image_uri,
                    uri = dto.uri,
                    order = dto.order,
                    lastUpdated = System.currentTimeMillis()
                )
            }
            questionDao.clearQuestions()
            questionDao.insertQuestions(questions)
            questions
        } catch (e: Exception) {
            e.printStackTrace()
            cachedQuestions
        }
    }

    private fun isDataStale(questions: List<QuestionEntity>): Boolean {
        val oneDayInMillis = 24 * 60 * 60 * 1000
        val lastUpdated = questions.firstOrNull()?.lastUpdated ?: 0
        return System.currentTimeMillis() - lastUpdated > oneDayInMillis
    }
}