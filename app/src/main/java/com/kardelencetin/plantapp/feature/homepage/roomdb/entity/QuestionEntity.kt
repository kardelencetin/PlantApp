package com.kardelencetin.plantapp.feature.homepage.roomdb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class QuestionEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val subtitle: String,
    val imageUri: String,
    val uri: String,
    val order: Int,
    val lastUpdated: Long
)