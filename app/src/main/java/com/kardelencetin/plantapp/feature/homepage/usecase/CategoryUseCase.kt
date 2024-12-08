package com.kardelencetin.plantapp.feature.homepage.usecase

import com.kardelencetin.plantapp.feature.homepage.repository.CategoryRepository
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.CategoryEntity
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke(): List<CategoryEntity> {
        return repository.getCategories()
    }
}