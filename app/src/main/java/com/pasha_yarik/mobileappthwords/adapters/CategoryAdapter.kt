package com.pasha_yarik.mobileappthwords.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.databinding.WordsListTemplateBinding

class CategoryAdapter:ListAdapter<CategoryModel,CategoryAdapter.CategoryHolder >(MyComporator()) {

    class CategoryHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding = WordsListTemplateBinding.bind(view)
        fun setWord(word: CategoryModel) = with(binding){

            tvCategoryName.text = word.name
            val quantity = "Количество слов: ${word.count}"
            tvCountWords.text = quantity
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.words_list_template,  parent,false)
        return CategoryHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.setWord(getItem(position))
    }

    class MyComporator :DiffUtil.ItemCallback<CategoryModel>(){
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }

    }

}