package com.kardelencetin.plantapp.feature.paywall.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.fragment.app.viewModels
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.paywall.viewmodel.PaywallViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaywallFragment : Fragment(R.layout.fragment_paywall) {

    private val viewModel: PaywallViewModel by viewModels()
    private lateinit var closeButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val closeButton = view.findViewById<Button>(R.id.buttonClose)
        closeButton.setOnClickListener {
            
        }

    }
}