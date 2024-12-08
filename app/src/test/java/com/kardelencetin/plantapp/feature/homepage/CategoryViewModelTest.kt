package com.kardelencetin.plantapp.feature.homepage

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kardelencetin.plantapp.core.util.getOrAwaitValue
import com.kardelencetin.plantapp.feature.homepage.model.Image
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.CategoryEntity
import com.kardelencetin.plantapp.feature.homepage.usecase.CategoryUseCase
import com.kardelencetin.plantapp.feature.homepage.viewmodel.CategoryViewModel
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CategoryViewModelTest {

    private val categoryUseCase: CategoryUseCase = mockk()

    private lateinit var viewModel: CategoryViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = CategoryViewModel(categoryUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchCategories should update categoriesLiveData when successful`() = runTest {
        val mockCategories = listOf(
            CategoryEntity(1, "Test Name", "Test Title", 1, Image(1, "image1", 100, 100, 100.0, "img_url"), 123456789L),
            CategoryEntity(2, "Another Name", "Another Title", 2, Image(2, "image2", 100, 100, 100.0, "img_url1"), 123456789L)
        )

        coEvery { categoryUseCase.invoke() } returns mockCategories

        viewModel.fetchCategories()

        assertEquals(mockCategories, viewModel.categoriesLiveData.getOrAwaitValue())
    }

    @Test
    fun `fetchCategories should handle exception and not update categoriesLiveData`() = runTest {
        coEvery { categoryUseCase.invoke() } throws RuntimeException("Test exception")

        viewModel.fetchCategories()

        assertNull(viewModel.categoriesLiveData.value)
    }
}