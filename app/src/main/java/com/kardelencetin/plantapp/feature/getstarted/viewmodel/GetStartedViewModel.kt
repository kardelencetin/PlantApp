package com.kardelencetin.plantapp.feature.getstarted.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kardelencetin.plantapp.feature.getstarted.model.GetStartedItem
import com.kardelencetin.plantapp.feature.getstarted.usecase.GetStartedItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GetStartedViewModel @Inject constructor(
    private val getGetStartedItemsUseCase: GetStartedItemsUseCase
) : ViewModel() {

    private val _getStartedItem = MutableLiveData<GetStartedItem>()
    val getStartedItems: LiveData<GetStartedItem> = _getStartedItem

    init {
        loadGetStartedItems()
    }

    private fun loadGetStartedItems() {
        _getStartedItem.value = getGetStartedItemsUseCase()
    }
}