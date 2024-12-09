package com.kardelencetin.plantapp.feature.paywall.usecase

import com.kardelencetin.plantapp.feature.paywall.model.FeatureOption
import com.kardelencetin.plantapp.feature.paywall.repository.FeatureRepository
import javax.inject.Inject

class GetFeatureOptionsUseCase @Inject constructor(
    private val repository: FeatureRepository
) {
    operator fun invoke(): List<FeatureOption> = repository.getFeatureOptions()
}