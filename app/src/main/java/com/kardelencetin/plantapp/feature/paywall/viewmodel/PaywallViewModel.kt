package com.kardelencetin.plantapp.feature.paywall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kardelencetin.plantapp.feature.paywall.model.PaywallOption
import com.kardelencetin.plantapp.feature.paywall.usecase.GetPaywallOptionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaywallViewModel @Inject constructor(
    private val getPaywallOptionsUseCase: GetPaywallOptionsUseCase
) : ViewModel() {

    private val _paywallOptions = MutableLiveData<List<PaywallOption>>()
    val paywallOptions: LiveData<List<PaywallOption>> = _paywallOptions

    init {
        loadPaywallOptions()
    }

    private fun loadPaywallOptions() {
        _paywallOptions.value = getPaywallOptionsUseCase()
    }
}