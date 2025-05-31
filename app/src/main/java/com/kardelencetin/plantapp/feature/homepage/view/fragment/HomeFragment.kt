package com.kardelencetin.plantapp.feature.homepage.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kardelencetin.plantapp.databinding.FragmentHomeBinding
import com.kardelencetin.plantapp.feature.homepage.adapter.CategoriesAdapter
import com.kardelencetin.plantapp.feature.homepage.adapter.QuestionsAdapter
import com.kardelencetin.plantapp.feature.homepage.viewmodel.CategoryViewModel
import com.kardelencetin.plantapp.feature.homepage.viewmodel.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.core.view.get

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val categoryViewModel: CategoryViewModel by viewModels()
    private val questionViewModel: QuestionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerCategories.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerQuestions.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        categoryViewModel.categoriesLiveData.observe(viewLifecycleOwner) { categories ->
            binding.recyclerCategories.adapter = CategoriesAdapter(categories)
        }

        questionViewModel.questionsLiveData.observe(viewLifecycleOwner) { questions ->
            binding.recyclerQuestions.adapter = QuestionsAdapter(questions)
        }

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu[2].isEnabled = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
