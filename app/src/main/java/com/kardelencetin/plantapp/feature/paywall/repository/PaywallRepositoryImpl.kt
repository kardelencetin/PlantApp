package com.kardelencetin.plantapp.feature.paywall.repository

import com.kardelencetin.plantapp.feature.paywall.model.PaywallOption
import javax.inject.Inject

class PaywallRepositoryImpl @Inject constructor() : PaywallRepository {
    override fun getPaywallOptions(): List<PaywallOption> {
        return listOf(
            PaywallOption(title = "1 Month", "$2.99/month, auto renewable", false),
            PaywallOption(title = "1 Year", "First 3 days Free, then $529,99/year", true)
        )
    }
}