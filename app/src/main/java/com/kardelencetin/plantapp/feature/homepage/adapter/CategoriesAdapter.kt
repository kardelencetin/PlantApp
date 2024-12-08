package com.kardelencetin.plantapp.feature.homepage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.CategoryEntity

class CategoriesAdapter(private val categories: List<CategoryEntity>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView = view.findViewById(R.id.categoryImage)
        private val titleView: TextView = view.findViewById(R.id.categoryTitle)

        fun bind(category: CategoryEntity) {
            Glide.with(itemView.context)
                .load(category.image.url)
                .into(imageView)
            titleView.text = category.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size
}