package com.pasha_yarik.mobileappthwords.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.databinding.WordsListTemplateBinding
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.pasha_yarik.mobileappthwords.MainActivity
import com.pasha_yarik.mobileappthwords.fragmentsP.LearnListFragment
import com.pasha_yarik.mobileappthwords.fragmentsP.ProcessFragment


class WordsAdapter(var listener: Listener2):ListAdapter<WordsModel,WordsAdapter.WordHolder >(MyComporator()) {

    class WordHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = WordsListTemplateBinding.bind(view)
        @SuppressLint("UseCompatLoadingForDrawables")
        fun setWord(word: WordsModel, listener: Listener2) = with(binding) {

            tvCategoryName.text = word.name

            val quantity = "Количество слов: ${word.count}"
            tvCountWords.text = quantity

            imSubCategory.setImageResource(word.image)


            val temp = word.textInProgres + "%"
            tvProgress100.text = temp
            progressKrug.progress = word.statusProgres!!


            val cError = "Допущено ошибок: ${word.countErrors}"
            tvCountError.text = cError


            if(word.textInProgres?.toInt() == 100 && word.countErrors == 0){

                progressKrug.backgroundTintList = ContextCompat.getColorStateList(progressKrug.context,R.color.gold_prog1)
                progressKrug.progressDrawable = ContextCompat.getDrawable(progressKrug.context,R.drawable.circle_progress_bar_gold)
            }
            clTemplWord.setOnClickListener {
                listener.onClickSubcategory(word)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.words_list_template, parent, false)
        return WordHolder(view)
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        holder.setWord(getItem(position), listener)
    }

    class MyComporator : DiffUtil.ItemCallback<WordsModel>() {
        override fun areItemsTheSame(oldItem: WordsModel, newItem: WordsModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WordsModel, newItem: WordsModel): Boolean {
            return oldItem == newItem
        }

    }

    interface Listener2 {
        fun onClickSubcategory(model: WordsModel)
    }

}