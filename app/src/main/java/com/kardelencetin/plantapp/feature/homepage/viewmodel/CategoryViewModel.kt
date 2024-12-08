package com.kardelencetin.plantapp.feature.homepage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kardelencetin.plantapp.feature.homepage.repository.CategoryRepository
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.CategoryEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: CategoryRepository
) : ViewModel() {

    private val _categoriesLiveData = MutableLiveData<List<CategoryEntity>>()
    val categoriesLiveData: LiveData<List<CategoryEntity>> get() = _categoriesLiveData

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val categories = repository.getCategories()
                _categoriesLiveData.postValue(categories)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}