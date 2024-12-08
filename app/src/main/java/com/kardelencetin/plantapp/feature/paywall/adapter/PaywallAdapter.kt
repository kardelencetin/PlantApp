package com.kardelencetin.plantapp.feature.paywall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.onboarding.adapter.OnboardingAdapter
import com.kardelencetin.plantapp.feature.onboarding.adapter.OnboardingAdapter.OnboardingViewHolder

class PaywallAdapter (private val onButtonClick: (Int) -> Unit): RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnboardingAdapter.OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_paywall_option, parent, false)
        return OnboardingViewHolder(view)    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: OnboardingAdapter.OnboardingViewHolder, position: Int) {
        holder.itemView.findViewById<Button>(R.id.buttonClose).setOnClickListener {
            onButtonClick(position)
        }
    }

}
