package com.pasha_yarik.mobileappthwords.fragmentsP

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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
    private var quantityWords: Int? = null
    private var wordsInSubcategory = 0
    private var wordList: Int? = null

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
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.placeHolder, LearnListFragment.newInstance()).commit()
            FragmentManager.currentFragment = LearnListFragment()
            bottomNav?.visibility = View.VISIBLE
        }
                // хуй
        model.mutableArraWords.observe(viewLifecycleOwner) {
            wordList = it
            Log.d("Mylock","${wordList}")
            when (wordList) {
                0 -> processSlova(0,resources.getStringArray(R.array.procc_array))
                1 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                2 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                3 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                4 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                5 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                6 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                7 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                8 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                9 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                10 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                11 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                12 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                13 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                14 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                15 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                16 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                17 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                18 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                19 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                20 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                21 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                22 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                23 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                24 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                25 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                26 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                27 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                28 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                29 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                31 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                32 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                33 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                34 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                35 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                36 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                37 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                38 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                39 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
            }
        }


    }



    private fun processSlova(size: Int, arr: Array<String>) {
        var siz = size
        val array = arr


        val array1 = array[siz].split("|")
        val adapter = ArrayAdapter<String>(requireContext(), R.layout.fragment_process, array1)

        binding.tvAnsWord.text = adapter.getItem(0)
        binding.bAnswer1.text = adapter.getItem(1)
        binding.bAnswer2.text = adapter.getItem(2)
        binding.bAnswer3.text = adapter.getItem(3)


        binding.bNextWord.setOnClickListener {
            siz += 1
            if (siz > arr.size - 1){requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.placeHolder,LearnListFragment.newInstance()).commit()
                FragmentManager.currentFragment = LearnListFragment()
                bottomNav?.visibility = View.VISIBLE

            }
            else {
                processSlova(siz, arr)
            }
        }
    }





        private fun nextWord() {
            if (wordsInSubcategory > 20) {

            } else {

            }
        }

        companion object {
            @JvmStatic
            fun newInstance() = ProcessFragment()
        }
}



