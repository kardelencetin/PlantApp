package com.kardelencetin.plantapp.feature.paywall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kardelencetin.plantapp.feature.paywall.model.FeatureOption
import com.kardelencetin.plantapp.feature.paywall.model.PaywallOption
import com.kardelencetin.plantapp.feature.paywall.usecase.GetFeatureOptionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureViewModel @Inject constructor(
private val getFeatureOptionUseCase: GetFeatureOptionsUseCase
) : ViewModel() {

    private val _featureOptions = MutableLiveData<List<FeatureOption>>()
    val featureOption: LiveData<List<FeatureOption>> = _featureOptions

    init {
        loadFeatureOptions()
    }

    private fun loadFeatureOptions() {
        _featureOptions.value = getFeatureOptionUseCase()
    }
}