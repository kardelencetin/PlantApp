package com.kardelencetin.plantapp.feature.onboarding.repository

import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.onboarding.model.OnboardingItem
import javax.inject.Inject

class OnboardingRepositoryImpl @Inject constructor() : OnboardingRepository {
    override fun getOnboardingItems(): List<OnboardingItem> {
        return listOf(
            OnboardingItem(
                title = "Take a photo to identify the plant!",
                imageUrl = R.drawable.onboarding_first
            ),
            OnboardingItem(
                title = "Get plant care guides",
                imageUrl = R.drawable.onboarding_second
            )
        )
    }
}