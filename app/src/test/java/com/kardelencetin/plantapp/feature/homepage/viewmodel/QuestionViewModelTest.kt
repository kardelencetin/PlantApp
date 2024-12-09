package com.kardelencetin.plantapp.feature.homepage.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kardelencetin.plantapp.core.util.getOrAwaitValue
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.QuestionEntity
import com.kardelencetin.plantapp.feature.homepage.usecase.QuestionUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class QuestionViewModelTest {

    private val questionUseCase: QuestionUseCase = mockk()

    private lateinit var viewModel: QuestionViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = QuestionViewModel(questionUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchQuestions should update questionsLiveData when successful`() = runTest {
        val mockCategories = listOf(
            QuestionEntity(1, "title1", "subtitle1", "image1", "uri1", 1, 123456789L),
            QuestionEntity(2, "title2", "subtitle2", "image2", "uri2", 2, 123456788L),
        )

        coEvery { questionUseCase.invoke() } returns mockCategories

        viewModel.fetchQuestions()

        assertEquals(mockCategories, viewModel.questionsLiveData.getOrAwaitValue())
    }

    @Test
    fun `fetchQuestions should handle exception and not update questionsLiveData`() = runTest {
        coEvery { questionUseCase.invoke() } throws RuntimeException("Test exception")

        viewModel.fetchQuestions()

        assertNull(viewModel.questionsLiveData.value)
    }
}