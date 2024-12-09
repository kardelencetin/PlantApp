package com.kardelencetin.plantapp.feature.paywall.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.paywall.model.PaywallOption

class PaywallAdapter(
    private val options: List<PaywallOption>,
    private val onOptionSelected: (Int) -> Unit
) : RecyclerView.Adapter<PaywallAdapter.PaywallViewHolder>() {

    private var selectedPosition: Int = -1

    inner class PaywallViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val radioOption: RadioButton = view.findViewById(R.id.radioOption)
        val title: TextView = view.findViewById(R.id.optionTitle)
        val subtitle: TextView = view.findViewById(R.id.optionSubtitle)
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
        holder.radioOption.isChecked = position == selectedPosition

        holder.radioOption.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(previousPosition)
            notifyItemChanged(position)
            onOptionSelected(position)
        }
    }
}
