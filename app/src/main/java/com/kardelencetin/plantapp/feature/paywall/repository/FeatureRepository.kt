package com.kardelencetin.plantapp.feature.paywall.repository

import com.kardelencetin.plantapp.feature.paywall.model.FeatureOption

interface FeatureRepository {
    fun getFeatureOptions(): List<FeatureOption>
}