package com.kardelencetin.plantapp.feature.onboarding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kardelencetin.plantapp.feature.onboarding.model.OnboardingItem
import com.kardelencetin.plantapp.feature.onboarding.usecase.OnboardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val onboardingUseCase: OnboardingUseCase
) : ViewModel() {

    private val _onboardingItems = MutableLiveData<List<OnboardingItem>>()
    val onboardingItems: LiveData<List<OnboardingItem>> = _onboardingItems

    init {
        loadOnboardingItems()
    }

    private fun loadOnboardingItems() {
        _onboardingItems.value = onboardingUseCase()
    }
}