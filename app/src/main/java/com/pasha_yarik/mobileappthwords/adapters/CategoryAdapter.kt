package com.pasha_yarik.mobileappthwords.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.databinding.BigCubeTemplateBinding
import com.pasha_yarik.mobileappthwords.databinding.WordsListTemplateBinding
import pl.droidsonroids.gif.GifDrawable
import java.io.InputStream



class CategoryAdapter(var listener: Listener):ListAdapter<CategoryModel,CategoryAdapter.CategoryHolder >(MyComporatorr()) {

    class CategoryHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding = BigCubeTemplateBinding.bind(view)
        fun setCategory(category: CategoryModel,listener: Listener) = with(binding){

            tvCubeTemp.text = category.nameCategory

            imCubeTemp.setImageResource(category.imageCategory)



            bCubeTemp.setOnClickListener{
                listener.onClick(category)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.big_cube_template,  parent,false)
        return CategoryHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.setCategory(getItem(position), listener)
    }

    class MyComporatorr :DiffUtil.ItemCallback<CategoryModel>(){
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }

    }

    interface Listener{
        fun onClick(category:CategoryModel)
    }

}