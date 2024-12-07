package com.kardelencetin.plantapp.feature.onboarding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.onboarding.model.OnboardingItem

class OnboardingAdapter(
    private var items: List<OnboardingItem>,
    private val onButtonClick: (Int) -> Unit
) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    fun setItems(newItems: List<OnboardingItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

        holder.itemView.findViewById<Button>(R.id.buttonOnBoarding).setOnClickListener {
            onButtonClick(position)
        }
    }

    override fun getItemCount(): Int = items.size

    class OnboardingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.textTitle)
        private val imageOnboarding = itemView.findViewById<ImageView>(R.id.imageOnboarding)

        fun bind(item: OnboardingItem) {
            title.text = item.title
            imageOnboarding.setImageResource(item.imageUrl)
        }
    }
}