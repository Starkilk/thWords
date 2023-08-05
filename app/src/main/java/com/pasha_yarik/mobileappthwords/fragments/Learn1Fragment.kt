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
        R.drawable.man8,
        R.drawable.harakter8,
        R.drawable.number8,
        R.drawable.glagol8,
        R.drawable.food8,
        R.drawable.earth8,
        R.drawable.place8,
        R.drawable.house8,

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
        val arrayNumCat = resources.getStringArray(R.array.numCategories)

        array.forEachIndexed() {index, element->
            tempArray.add(CategoryModel(element,imageIdList[index], arrayNumCat[index]))

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

    private fun fillSubcategoriList(category: CategoryModel){
        val tempList = ArrayList<WordsModel>()

        category.arrayNumber.split(",").forEach{
            val subcategoriList = resources.getStringArray(R.array.subcategories)
            val subcategori = subcategoriList[it.toInt()]
            val subcategoriArray = subcategori.split("|")

            tempList.add(WordsModel(subcategoriArray[0],subcategoriArray[1]))
        }
        model.mutableListWords.value = tempList
    }

    companion object {
        @JvmStatic
        fun newInstance() = Learn1Fragment()
    }

    override fun onClick(category: CategoryModel) {
        fillSubcategoriList(category)
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.placeHolder,LearnListFragment.newInstance()).commit()
        FragmentManager.currentFragment = LearnListFragment()
    }
}