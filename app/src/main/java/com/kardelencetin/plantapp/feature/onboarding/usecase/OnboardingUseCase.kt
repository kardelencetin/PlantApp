package com.kardelencetin.plantapp.feature.onboarding.usecase

import com.kardelencetin.plantapp.feature.onboarding.model.OnboardingItem
import com.kardelencetin.plantapp.feature.onboarding.repository.OnboardingRepository
import javax.inject.Inject

class OnboardingUseCase @Inject constructor(
    private val repository: OnboardingRepository
) {
    operator fun invoke(): List<OnboardingItem> {
        return repository.getOnboardingItems()
    }
}