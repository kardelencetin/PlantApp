package com.kardelencetin.plantapp.feature.paywall.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.core.preferences.PreferencesManager
import com.kardelencetin.plantapp.databinding.FragmentPaywallBinding
import com.kardelencetin.plantapp.feature.homepage.view.activity.HomeActivity
import com.kardelencetin.plantapp.feature.paywall.adapter.FeatureAdapter
import com.kardelencetin.plantapp.feature.paywall.adapter.PaywallAdapter
import com.kardelencetin.plantapp.feature.paywall.viewmodel.FeatureViewModel
import com.kardelencetin.plantapp.feature.paywall.viewmodel.PaywallViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaywallFragment : Fragment() {

    private var _binding: FragmentPaywallBinding? = null
    private val binding get() = _binding!!

    private val featureViewModel: FeatureViewModel by viewModels()
    private val paywallViewModel: PaywallViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaywallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonClose.setOnClickListener {
            PreferencesManager.setOnboardingCompleted(requireContext())

            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            requireActivity().finish()
        }

        binding.featureRecycler.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.featureRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.pricingRecycler.layoutManager = GridLayoutManager(requireContext(), 1)

        paywallViewModel.paywallOptions.observe(viewLifecycleOwner) { options ->
            binding.pricingRecycler.adapter = PaywallAdapter(options) { selectedPosition ->
                val selectedOption = options[selectedPosition]
            }
        }

        featureViewModel.featureOption.observe(viewLifecycleOwner) { features ->
            binding.featureRecycler.adapter = FeatureAdapter(features)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}