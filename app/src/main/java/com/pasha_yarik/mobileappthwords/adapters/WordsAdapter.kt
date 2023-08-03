package com.pasha_yarik.mobileappthwords.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.databinding.WordsListTemplateBinding

class WordsAdapter:ListAdapter<WordsModel,WordsAdapter.WordHolder >(MyComporator()) {

    class WordHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding = WordsListTemplateBinding.bind(view)
        fun setWord(word: WordsModel) = with(binding){

            tvCategoryName.text = word.name
            val quantity = "Количество слов: ${word.count}"
            tvCountWords.text = quantity
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.words_list_template,  parent,false)
        return WordHolder(view)
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        holder.setWord(getItem(position))
    }

    class MyComporator :DiffUtil.ItemCallback<WordsModel>(){
        override fun areItemsTheSame(oldItem: WordsModel, newItem: WordsModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WordsModel, newItem: WordsModel): Boolean {
            return oldItem == newItem
        }

    }

}