package com.pasha_yarik.mobileappthwords.fragmentsP

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.adapters.CategoryModel
import com.pasha_yarik.mobileappthwords.adapters.WordsAdapter
import com.pasha_yarik.mobileappthwords.adapters.WordsModel
import com.pasha_yarik.mobileappthwords.databinding.FragmentProcessBinding
import com.pasha_yarik.mobileappthwords.utils.FragmentManager
import com.pasha_yarik.mobileappthwords.utils.MainViewModel


class ProcessFragment : Fragment() {
    private lateinit var binding: FragmentProcessBinding
    private var bottomNav: BottomNavigationView? = null
    private val model: MainViewModel by activityViewModels()
    private var quantityWords: Int?  = null
    private var wordsInSubcategory = 0
    private var wordList:Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProcessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNav = activity?.findViewById(R.id.bnvNav)

        //при нажатии на крестик закрывается фрагмент и открывается предыдущий с выбором подкатегорий и навигация становится визибл
        binding.imCloseProcess.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.placeHolder,LearnListFragment.newInstance()).commit()
            FragmentManager.currentFragment = LearnListFragment()
            bottomNav?.visibility = View.VISIBLE
        }

        model.mutableArraWords.observe(viewLifecycleOwner){
            wordList = it
            Log.d("MyLig","${wordList}")

        }

    }

    private fun nextWord(){
        if(wordsInSubcategory > 20){

        }else{

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProcessFragment()
    }
}


