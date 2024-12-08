package com.kardelencetin.plantapp.feature.homepage.roomdb.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kardelencetin.plantapp.feature.homepage.model.Image

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val title: String,
    val rank: Int,
    @Embedded(prefix = "image_")
    val image: Image,
    val lastUpdated: Long
)