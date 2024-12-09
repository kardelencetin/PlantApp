package com.kardelencetin.plantapp.feature.paywall.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.core.preferences.PreferencesManager
import com.kardelencetin.plantapp.feature.homepage.view.activity.HomeActivity
import com.kardelencetin.plantapp.feature.paywall.adapter.FeatureAdapter
import com.kardelencetin.plantapp.feature.paywall.adapter.PaywallAdapter
import com.kardelencetin.plantapp.feature.paywall.viewmodel.FeatureViewModel
import com.kardelencetin.plantapp.feature.paywall.viewmodel.PaywallViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaywallFragment : Fragment(R.layout.fragment_paywall) {

    private val featureViewModel: FeatureViewModel by viewModels()
    private val paywallViewModel: PaywallViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonClose = view.findViewById<ImageView>(R.id.buttonClose)
        buttonClose.setOnClickListener {
            PreferencesManager.setOnboardingCompleted(requireContext())

            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            requireActivity().finish()
        }

        val recyclerFeature = view.findViewById<RecyclerView>(R.id.featureRecycler)
        recyclerFeature.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val recyclerPrices = view.findViewById<RecyclerView>(R.id.pricingRecycler)
        recyclerPrices.layoutManager = GridLayoutManager(requireContext(), 1)

        paywallViewModel.paywallOptions.observe(viewLifecycleOwner) { options ->
            recyclerPrices.adapter = PaywallAdapter(options) { selectedPosition ->
                val selectedOption = options[selectedPosition]
            }
        }

        featureViewModel.featureOption.observe(viewLifecycleOwner) { features ->
            recyclerFeature.adapter = FeatureAdapter(features)
        }
    }
}