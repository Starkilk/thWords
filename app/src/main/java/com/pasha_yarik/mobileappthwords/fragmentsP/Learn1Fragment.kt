package com.pasha_yarik.mobileappthwords.fragmentsP

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.adapters.CategoryAdapter
import com.pasha_yarik.mobileappthwords.adapters.CategoryModel
import com.pasha_yarik.mobileappthwords.adapters.WordsModel
import com.pasha_yarik.mobileappthwords.databinding.FragmentLearn1Binding
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

    private val imageSubCategory = listOf(//лист с нашими изображениями
        R.drawable.compman1,
        R.drawable.hehim1,
        R.drawable.famyli1,
        R.drawable.body1,
        R.drawable.heart1,
        R.drawable.fanyboy1,
        R.drawable.pofig1,
        R.drawable.sadboy1,
        R.drawable.work1,
        R.drawable.work_zadacha1,
        R.drawable.clothes1,

        R.drawable.colors2,
        R.drawable.svoistva2,
        R.drawable.process2,

        R.drawable.digits3,
        R.drawable.poradok3,
        R.drawable.clock3,
        R.drawable.promejytok3,
        R.drawable.money3,

        R.drawable.hobby4,
        R.drawable.traveling4,
        R.drawable.dvijenie4,
        R.drawable.live4,
        R.drawable.communication4,
        R.drawable.question4,
        R.drawable.emotions4,
        R.drawable.chyvsta4,
        R.drawable.mishlenie4,
        R.drawable.learn4,
        R.drawable.modalglag4,

        R.drawable.coocking5,
        R.drawable.produkti5,
        R.drawable.posyda5,

        R.drawable.fayna6,
        R.drawable.priroda6,

        R.drawable.event7,
        R.drawable.point7,

        R.drawable.hous8,
        R.drawable.pribori8,
        R.drawable.veshi8,


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

        //val arrayNumProcess = resources.getStringArray(R.array.word_distribution)
        category.arrayNumber.split(",").forEachIndexed(){it,element->
            val subcategoriList = resources.getStringArray(R.array.subcategories)
            val subcategori = subcategoriList[element.toInt()]
            val subcategoriArray = subcategori.split("|")

            tempList.add(WordsModel(subcategoriArray[0],subcategoriArray[1],imageSubCategory[subcategoriArray[2].toInt()],subcategoriArray[2].toInt()))
        }
        model.mutableListWords.value = tempList
    }



    companion object {
        @JvmStatic
        fun newInstance() = Learn1Fragment()
    }

    override fun onClickCategory(category: CategoryModel) {
        fillSubcategoriList(category)
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.placeHolder,LearnListFragment.newInstance()).commit()
        FragmentManager.currentFragment = LearnListFragment()
    }
}