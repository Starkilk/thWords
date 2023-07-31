package com.pasha_yarik.mobileappthwords.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pasha_yarik.mobileappthwords.MainActivity
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.adapters.CategoryAdapter
import com.pasha_yarik.mobileappthwords.adapters.CategoryModel
import com.pasha_yarik.mobileappthwords.adapters.WordsAdapter
import com.pasha_yarik.mobileappthwords.adapters.WordsModel
import com.pasha_yarik.mobileappthwords.databinding.FragmentLearn1Binding
import com.pasha_yarik.mobileappthwords.databinding.FragmentLearnListBinding
import com.pasha_yarik.mobileappthwords.utils.FragmentManager


class Learn1Fragment : Fragment() {
    private lateinit var binding: FragmentLearn1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLearn1Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRcView()

    }

    //заполнение массива данными
    private fun fillCategoryArray():ArrayList<CategoryModel>{
        val tempArray = ArrayList<CategoryModel>()
        resources.getStringArray(R.array.categorii).forEach {
            val categoryArr = it.split("|")
            tempArray.add(CategoryModel(categoryArr[0],categoryArr[1],))

        }
        return tempArray
    }

    //передача заполненного массива в адаптер
    private fun initRcView() = with(binding){
        val adapter = CategoryAdapter()
        rcCategoryP.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        rcCategoryP.adapter = adapter
        adapter.submitList(fillCategoryArray())
    }

    companion object {
        @JvmStatic
        fun newInstance() = Learn1Fragment()
    }
}