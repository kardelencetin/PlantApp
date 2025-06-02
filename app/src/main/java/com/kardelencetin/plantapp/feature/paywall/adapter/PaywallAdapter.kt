package com.kardelencetin.plantapp.feature.paywall.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.paywall.model.PaywallOption

class PaywallAdapter(
    private val options: List<PaywallOption>,
    private val onOptionSelected: (Int) -> Unit
) : RecyclerView.Adapter<PaywallAdapter.PaywallViewHolder>() {

    private var selectedPosition: Int = 0

    inner class PaywallViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardRoot: MaterialCardView = view.findViewById(R.id.cardRoot)
        val radioOption: ImageView = view.findViewById(R.id.radioOption)
        val title: TextView = view.findViewById(R.id.optionTitle)
        val subtitle: TextView = view.findViewById(R.id.optionSubtitle)
        val badge: TextView = view.findViewById(R.id.optionBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaywallViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_paywall_option, parent, false)
        return PaywallViewHolder(view)
    }

    override fun getItemCount(): Int = options.size

    override fun onBindViewHolder(holder: PaywallViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val option = options[position]

        holder.title.text = option.title
        holder.subtitle.text = option.description

        if (position == selectedPosition) {
            holder.radioOption.setImageResource(R.drawable.selected_radio_button)
            holder.cardRoot.strokeColor = holder.itemView.context.getColor(R.color.button_bg)
            holder.cardRoot.alpha = 0.8F
        } else {
            holder.radioOption.setImageResource(R.drawable.unselected_radio_button)
            holder.cardRoot.strokeColor = holder.itemView.context.getColor(R.color.option_border_default)
            holder.cardRoot.alpha = 1F
        }

        holder.badge.visibility = if (option.hasBadge) View.VISIBLE else View.GONE

        val clickListener = View.OnClickListener {
            val oldPos = selectedPosition
            selectedPosition = position
            notifyItemChanged(oldPos)
            notifyItemChanged(position)
            onOptionSelected(position)
        }
        holder.itemView.setOnClickListener(clickListener)
        holder.radioOption.setOnClickListener(clickListener)
    }
}