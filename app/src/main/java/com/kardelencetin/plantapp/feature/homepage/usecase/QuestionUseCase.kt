package com.kardelencetin.plantapp.feature.homepage.usecase

import com.kardelencetin.plantapp.feature.homepage.repository.QuestionRepository
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.QuestionEntity
import javax.inject.Inject

class QuestionUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    suspend operator fun invoke(): List<QuestionEntity> {
        return repository.getQuestions()
    }
}