package com.kardelencetin.plantapp.feature.paywall.repository

import com.kardelencetin.plantapp.feature.paywall.model.PaywallOption

interface PaywallRepository {
    fun getPaywallOptions(): List<PaywallOption>
}