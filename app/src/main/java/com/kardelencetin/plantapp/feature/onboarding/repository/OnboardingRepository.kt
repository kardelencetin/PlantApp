package com.kardelencetin.plantapp.feature.onboarding.repository

import com.kardelencetin.plantapp.feature.onboarding.model.OnboardingItem

interface OnboardingRepository {
    fun getOnboardingItems(): List<OnboardingItem>
}