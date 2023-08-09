package com.pasha_yarik.mobileappthwords.fragmentsP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.adapters.WordsAdapter
import com.pasha_yarik.mobileappthwords.adapters.WordsModel
import com.pasha_yarik.mobileappthwords.databinding.FragmentLearnList1Binding
import com.pasha_yarik.mobileappthwords.utils.FragmentManager
import com.pasha_yarik.mobileappthwords.utils.MainViewModel

class LearnListFragment : Fragment(), WordsAdapter.Listener2 {
    private lateinit var binding: FragmentLearnList1Binding
    private val model: MainViewModel by activityViewModels()
    private lateinit var adapter: WordsAdapter
    private var navigViewMain :BottomNavigationView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLearnList1Binding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigViewMain = activity?.findViewById(R.id.bnvNav)!!

        initRcList()

        model.mutableListWords.observe(viewLifecycleOwner) { item ->

            val element = item[0]
            var key = element.arrayProcess

            item.forEach() {

                it.statusProgres = model.getProgr(key.toString())
                key++
            }

            adapter.submitList(item)

        }



    }

    private fun fillXyil(word: WordsModel){
        val digit = word.arrayProcess
        model.mutableArraWords.value = digit

    }



    //передача заполненного массива в адаптер
    private fun initRcList() = with(binding){
        adapter = WordsAdapter(this@LearnListFragment)
        rcViewList.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        rcViewList.adapter = adapter

    }

    companion object {
        @JvmStatic
        fun newInstance() = LearnListFragment()
    }

    override fun onClickSubcategory(word: WordsModel) {
        fillXyil(word)
        model.currentWord = word.arrayProcess
        navigViewMain?.visibility = View.GONE//сделал bottomNavigation невидимым
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.placeHolder,ProcessFragment.newInstance()).commit()
        FragmentManager.currentFragment = ProcessFragment()
    }
}