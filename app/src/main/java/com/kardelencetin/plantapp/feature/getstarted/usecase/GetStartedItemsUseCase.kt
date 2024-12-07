package com.kardelencetin.plantapp.feature.getstarted.usecase

import com.kardelencetin.plantapp.feature.getstarted.model.GetStartedItem
import com.kardelencetin.plantapp.feature.getstarted.repository.GetStartedRepository
import javax.inject.Inject

class GetStartedItemsUseCase @Inject constructor(
    private val repository: GetStartedRepository
) {
    operator fun invoke(): GetStartedItem {
        return repository.getGetStartedItems()
    }
}