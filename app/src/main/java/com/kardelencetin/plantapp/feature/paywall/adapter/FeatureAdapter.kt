package com.kardelencetin.plantapp.feature.paywall.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.paywall.model.FeatureOption

class FeatureAdapter (
    private val feature: List<FeatureOption>
) : RecyclerView.Adapter<FeatureAdapter.FeatureViewHolder>() {

    inner class FeatureViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.featureTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feature_option, parent, false)
        return FeatureViewHolder(view)
    }

    override fun getItemCount(): Int = feature.size

    override fun onBindViewHolder(holder: FeatureViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val option = feature[position]

        holder.title.text = option.title
    }
}
