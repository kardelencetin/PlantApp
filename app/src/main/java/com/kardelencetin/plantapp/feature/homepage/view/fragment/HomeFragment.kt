package com.kardelencetin.plantapp.feature.homepage.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.homepage.adapter.CategoriesAdapter
import com.kardelencetin.plantapp.feature.homepage.adapter.QuestionsAdapter
import com.kardelencetin.plantapp.feature.homepage.viewmodel.CategoryViewModel
import com.kardelencetin.plantapp.feature.homepage.viewmodel.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val categoryViewModel: CategoryViewModel by viewModels()
    private val questionViewModel: QuestionViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerCategories = view.findViewById<RecyclerView>(R.id.recyclerCategories)
        recyclerCategories.layoutManager = GridLayoutManager(requireContext(), 2)

        val recyclerQuestions = view.findViewById<RecyclerView>(R.id.recyclerQuestions)
        recyclerQuestions.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        categoryViewModel.categoriesLiveData.observe(viewLifecycleOwner) { categories ->
            recyclerCategories.adapter = CategoriesAdapter(categories)
        }

        questionViewModel.questionsLiveData.observe(viewLifecycleOwner) { questions ->
            recyclerQuestions.adapter = QuestionsAdapter(questions)
        }
    }
}