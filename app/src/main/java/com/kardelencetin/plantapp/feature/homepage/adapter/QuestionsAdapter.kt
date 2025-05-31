package com.kardelencetin.plantapp.feature.homepage.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.feature.homepage.roomdb.entity.QuestionEntity
import com.squareup.picasso.Picasso
import androidx.core.net.toUri

class QuestionsAdapter(private val questions: List<QuestionEntity>) :
    RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder>() {

    class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView = view.findViewById(R.id.questionImage)
        private val titleView: TextView = view.findViewById(R.id.questionTitle)

        fun bind(question: QuestionEntity) {
            Picasso.get()
                .load(question.imageUri)
                .into(imageView)
            titleView.text = question.title
            imageView.setOnClickListener {
                val context = imageView.context
                val intent = Intent(Intent.ACTION_VIEW, question.uri.toUri())
                context.startActivity(intent)
            }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_question, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(questions[position])
    }

    override fun getItemCount(): Int = questions.size
}