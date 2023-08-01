package com.pasha_yarik.mobileappthwords.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
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
import com.pasha_yarik.mobileappthwords.utils.MainViewModel


class Learn1Fragment : Fragment(), CategoryAdapter.Listener {
    private lateinit var binding: FragmentLearn1Binding
    private val model: MainViewModel by activityViewModels()

    private val imageIdList = listOf(//лист с нашими изображениями
        R.drawable.free_icon_employee_2553157,
        R.drawable.free_icon_letter_i_7825813,
        R.drawable.free_icon_progress_8124988,
        R.drawable.free_icon_lifestyles_6193322,
        R.drawable.free_icon_goulash_4727284,
        R.drawable.free_icon_melting_6968300,
        R.drawable.free_icon_place_1692037,
        R.drawable.free_icon_house_2163350,

        )

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
        val array = resources.getStringArray(R.array.categorii)
        array.forEachIndexed() {index, element->
            val words = array[index]
            val wordsArray = words.split("|")
            tempArray.add(CategoryModel(element,imageIdList[index],wordsArray[1]))

        }
        return tempArray
    }

    //передача заполненного массива в адаптер
    private fun initRcView() = with(binding){
        val adapter = CategoryAdapter(this@Learn1Fragment)
        rcCategoryP.layoutManager = GridLayoutManager(activity,2)
        rcCategoryP.adapter = adapter
        adapter.submitList(fillCategoryArray())
    }

    private fun nameArray(category: CategoryModel){
        val tempList = ArrayList<WordsModel>()
        val nameArr = category.nameCategory

        model.mutableListWords.value = nameArr
    }

    companion object {
        @JvmStatic
        fun newInstance() = Learn1Fragment()
    }

    override fun onClick(category: CategoryModel) {
        nameArray(category)
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.placeHolder,LearnListFragment.newInstance()).commit()
    }
}