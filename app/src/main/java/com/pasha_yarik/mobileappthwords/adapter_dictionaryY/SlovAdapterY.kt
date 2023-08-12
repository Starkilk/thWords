package com.pasha_yarik.mobileappthwords.adapter_dictionaryY

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.databinding.SlovListItemYBinding



class SlovAdapterY() : ListAdapter<SlovDataModelY, SlovAdapterY.SlovHolder>(MyComparator()) {

    class SlovHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = SlovListItemYBinding.bind(view)

        fun setData(slov: SlovDataModelY) = with(binding) {

            val englWord = slov.EnglishWord
            val russWord = slov.RussianWord

            tvEnglish.text = englWord
            tvRussian.text = russWord

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlovHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slov_list_item_y, parent, false)
        return SlovHolder(view)
    }

    override fun onBindViewHolder(holder: SlovHolder, position: Int) {
        holder.setData(getItem(position))
    }


    class MyComparator : DiffUtil.ItemCallback<SlovDataModelY>() {

        override fun areItemsTheSame(oldItem: SlovDataModelY, newItem: SlovDataModelY): Boolean {
            return oldItem == newItem
        }


        override fun areContentsTheSame(oldItem: SlovDataModelY, newItem: SlovDataModelY): Boolean {
            return oldItem == newItem
        }
    }
}