package com.kardelencetin.plantapp.feature.paywall.repository

import com.kardelencetin.plantapp.feature.paywall.model.FeatureOption
import javax.inject.Inject

class FeatureRepositoryImpl @Inject constructor() : FeatureRepository {
    override fun getFeatureOptions(): List<FeatureOption> {
        return listOf(
            FeatureOption(title = "Unlimited", "Plant Identify"),
            FeatureOption(title = "Faster", "Process"),
            FeatureOption(title = "Faster", "Process")
        )
    }
}