package com.kardelencetin.plantapp.feature.homepage.roomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kardelencetin.plantapp.feature.homepage.roomdb.dao.CategoryDao
import com.kardelencetin.plantapp.feature.homepage.roomdb.dao.QuestionDao
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.CategoryEntity
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.QuestionEntity

@Database(entities = [CategoryEntity::class, QuestionEntity::class], version = 1)
abstract class PlantDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun questionDao(): QuestionDao

    companion object {
        @Volatile
        private var instance: PlantDatabase? = null
        private val lock = Any()

        operator fun invoke(context: Context): PlantDatabase {
            return instance ?: synchronized(lock) {
                instance ?: createDatabase(context).also { instance = it }
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PlantDatabase::class.java,
            "plant_database"
        ).fallbackToDestructiveMigration().build()
    }
}