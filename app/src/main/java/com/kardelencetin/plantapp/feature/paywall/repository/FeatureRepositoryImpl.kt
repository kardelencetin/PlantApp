package com.kardelencetin.plantapp.feature.paywall.repository

import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.paywall.model.FeatureOption
import javax.inject.Inject

class FeatureRepositoryImpl @Inject constructor() : FeatureRepository {
    override fun getFeatureOptions(): List<FeatureOption> {
        return listOf(
            FeatureOption(title = "Unlimited", "Plant Identify", R.drawable.paywall_feature_scan),
            FeatureOption(title = "Faster", "Process", R.drawable.paywall_feature_speed),
            FeatureOption(title = "Faster", "Process", R.drawable.paywall_feature_speed)
        )
    }
}