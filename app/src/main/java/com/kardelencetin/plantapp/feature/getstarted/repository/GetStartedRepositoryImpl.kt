package com.kardelencetin.plantapp.feature.getstarted.repository

import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.getstarted.model.GetStartedItem
import javax.inject.Inject

class GetStartedRepositoryImpl @Inject constructor() : GetStartedRepository {
    override fun getGetStartedItems(): GetStartedItem {
        return GetStartedItem(
                title = "Welcome to PlantApp",
                description = "Identify more than 3000+ plants with \n88% accuracy.",
                imageUrl = R.drawable.plant,
                privacy = "By tapping next, you are agreeing to PlantID \n Terms of Use Privacy Policy."
        )
    }
}