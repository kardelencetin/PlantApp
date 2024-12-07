package com.kardelencetin.plantapp.feature.getstarted.repository

import com.kardelencetin.plantapp.feature.getstarted.model.GetStartedItem

interface GetStartedRepository {
    fun getGetStartedItems(): GetStartedItem
}