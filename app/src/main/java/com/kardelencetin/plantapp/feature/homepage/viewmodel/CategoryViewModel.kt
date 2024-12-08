package com.kardelencetin.plantapp.feature.homepage.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kardelencetin.plantapp.feature.homepage.repository.CategoryRepository
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.CategoryEntity
import com.kardelencetin.plantapp.feature.homepage.usecase.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
    ) : ViewModel() {

    private val _categoriesLiveData = MutableLiveData<List<CategoryEntity>>()
    val categoriesLiveData: LiveData<List<CategoryEntity>> get() = _categoriesLiveData

    init {
        fetchCategories()
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val categories = categoryUseCase()
                _categoriesLiveData.postValue(categories)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
