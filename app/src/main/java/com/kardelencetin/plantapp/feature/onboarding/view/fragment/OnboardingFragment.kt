package com.kardelencetin.plantapp.feature.onboarding.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.onboarding.adapter.OnboardingAdapter
import com.kardelencetin.plantapp.feature.onboarding.viewmodel.OnboardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private val viewModel: OnboardingViewModel by viewModels()
    private lateinit var indicatorLayout: LinearLayout
    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)
        indicatorLayout = view.findViewById(R.id.indicatorLayout)

        val adapter = OnboardingAdapter(emptyList()) { position ->
            handleButtonClick(position)
        }
        viewPager.adapter = adapter
        viewModel.onboardingItems.observe(viewLifecycleOwner) { items ->
            adapter.setItems(items)
            setupIndicators(items.size)
            setCurrentIndicator(0)
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setCurrentIndicator(position)
            }
        })
    }

    private fun setupIndicators(count: Int) {
        indicatorLayout.removeAllViews()
        val indicators = Array(count) {
            ImageView(requireContext()).apply {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator_inactive
                    )
                )
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(8, 0, 8, 0)
                }
            }
        }
        indicators.forEach { indicatorLayout.addView(it) }
    }

    private fun handleButtonClick(position: Int) {
        if (position == viewModel.onboardingItems.value?.size?.minus(1)) {
            findNavController().navigate(R.id.action_onboardingFragment_to_paywallFragment)
        } else {
            viewPager.currentItem = position + 1
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = indicatorLayout.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorLayout.getChildAt(i) as ImageView
            imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    if (i == index) R.drawable.indicator_active else R.drawable.indicator_inactive
                )
            )
        }
    }
}