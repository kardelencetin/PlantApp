package com.kardelencetin.plantapp.feature.homepage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kardelencetin.plantapp.feature.homepage.repository.QuestionRepository
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.QuestionEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val repository: QuestionRepository
) : ViewModel() {

    private val _questionsLiveData = MutableLiveData<List<QuestionEntity>>()
    val questionsLiveData: LiveData<List<QuestionEntity>> get() = _questionsLiveData

    init {
        fetchQuestions()
    }

    private fun fetchQuestions() {
        viewModelScope.launch {
            try {
                val questions = repository.getQuestions()
                _questionsLiveData.postValue(questions)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}