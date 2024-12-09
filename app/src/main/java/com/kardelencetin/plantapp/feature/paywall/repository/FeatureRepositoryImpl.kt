package com.kardelencetin.plantapp.feature.paywall.repository

import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.paywall.model.FeatureOption
import javax.inject.Inject

class FeatureRepositoryImpl @Inject constructor() : FeatureRepository {
    override fun getFeatureOptions(): List<FeatureOption> {
        return listOf(
            FeatureOption(title = "Unlimited", "Plant Identify", R.drawable.scanner),
            FeatureOption(title = "Faster", "Process", R.drawable.faster_icon),
            FeatureOption(title = "Faster", "Process", R.drawable.faster_icon)
        )
    }
}