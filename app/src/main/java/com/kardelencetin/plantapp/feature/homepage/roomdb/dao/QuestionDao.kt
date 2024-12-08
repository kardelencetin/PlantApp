package com.kardelencetin.plantapp.feature.homepage.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.QuestionEntity

@Dao
interface QuestionDao {

    @Query("SELECT * FROM questions ORDER BY `order` ASC")
    suspend fun getAllQuestions(): List<QuestionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<QuestionEntity>)

    @Query("DELETE FROM questions")
    suspend fun clearQuestions()
}