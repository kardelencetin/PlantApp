package com.kardelencetin.plantapp.feature.paywall.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.paywall.model.FeatureOption
import com.squareup.picasso.Picasso

class FeatureAdapter (
    private val feature: List<FeatureOption>
) : RecyclerView.Adapter<FeatureAdapter.FeatureViewHolder>() {

    class FeatureViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.featureTitle)
        private val description: TextView = view.findViewById(R.id.featureDescription)
        private val image: ImageView = view.findViewById(R.id.featureIcon)

        fun bind(feature: FeatureOption) {
            Picasso.get()
                .load(feature.image)
                .into(image)
            title.text = feature.title
            description.text = feature.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feature_option, parent, false)
        return FeatureViewHolder(view)
    }

    override fun getItemCount(): Int = feature.size

    override fun onBindViewHolder(holder: FeatureViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(feature[position])
    }
}
