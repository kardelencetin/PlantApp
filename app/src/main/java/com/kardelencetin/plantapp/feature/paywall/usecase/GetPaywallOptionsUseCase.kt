package com.kardelencetin.plantapp.feature.paywall.usecase

import com.kardelencetin.plantapp.feature.paywall.model.PaywallOption
import com.kardelencetin.plantapp.feature.paywall.repository.PaywallRepository
import javax.inject.Inject

class GetPaywallOptionsUseCase @Inject constructor(
    private val repository: PaywallRepository
) {
    operator fun invoke(): List<PaywallOption> = repository.getPaywallOptions()
}