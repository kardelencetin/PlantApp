package com.kardelencetin.plantapp.feature.homepage.repository

import com.kardelencetin.plantapp.feature.homepage.roomdb.dao.CategoryDao
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.CategoryEntity
import com.kardelencetin.plantapp.feature.homepage.service.PlantService
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val api: PlantService,
    private val categoryDao: CategoryDao
) {
    suspend fun getCategories(): List<CategoryEntity> {
        val cachedCategories = categoryDao.getAllCategories()

        if (cachedCategories.isNotEmpty() && !isDataStale(cachedCategories)) {
            return cachedCategories
        }

        return try {
            val response = api.getCategories()
            val categories = response.data.map { dto ->
                CategoryEntity(
                    id = dto.id,
                    name = dto.name,
                    title = dto.title,
                    rank = dto.rank,
                    image = dto.image,
                    lastUpdated = System.currentTimeMillis()
                )
            }
            categoryDao.clearCategories()
            categoryDao.insertCategories(categories)
            categories
        } catch (e: Exception) {
            e.printStackTrace()
            cachedCategories
        }
    }

    private fun isDataStale(categories: List<CategoryEntity>): Boolean {
        val oneDayInMillis = 24 * 60 * 60 * 1000
        val lastUpdated = categories.firstOrNull()?.lastUpdated ?: 0
        return System.currentTimeMillis() - lastUpdated > oneDayInMillis
    }
}