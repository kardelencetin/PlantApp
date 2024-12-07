package com.kardelencetin.plantapp.feature.getstarted.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.getstarted.viewmodel.GetStartedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetStartedFragment : Fragment(R.layout.fragment_get_started) {

    private val viewModel: GetStartedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleTextView = view.findViewById<TextView>(R.id.textWelcome)
        val descriptionTextView = view.findViewById<TextView>(R.id.textDescription)
        val imageView = view.findViewById<ImageView>(R.id.imagePlant)
        val getStartedButton = view.findViewById<Button>(R.id.buttonGetStarted)
        val privacyTextView = view.findViewById<TextView>(R.id.textPrivacy)

        viewModel.getStartedItems.observe(viewLifecycleOwner) { item ->
            item?.let {
                titleTextView.text = it.title
                descriptionTextView.text = it.description
                Glide.with(this)
                    .load(it.imageUrl)
                    .into(imageView)
                privacyTextView.text = it.privacy
            }
        }

        getStartedButton.setOnClickListener {
            //findNavController().navigate(R.id.action_getStarted_to_nextFragment)
        }
    }
}