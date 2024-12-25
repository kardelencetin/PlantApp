package com.kardelencetin.plantapp.feature.getstarted.repository

import android.content.Context
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.getstarted.model.GetStartedItem

class GetStartedRepositoryImpl(
    private val context: Context
) : GetStartedRepository {
    override fun getGetStartedItems(): GetStartedItem {
        return GetStartedItem(
            title = context.getString(R.string.welcome_to),
            description =  context.getString(R.string.welcome_definition),
            imageUrl = R.drawable.plant_started,
            privacy =  context.getString(R.string.privacy_definition)
        )
    }
}