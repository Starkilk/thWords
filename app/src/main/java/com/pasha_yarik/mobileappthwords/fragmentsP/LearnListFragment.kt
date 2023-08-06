package com.pasha_yarik.mobileappthwords.fragmentsP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pasha_yarik.mobileappthwords.adapters.WordsAdapter
import com.pasha_yarik.mobileappthwords.databinding.FragmentLearnListBinding
import com.pasha_yarik.mobileappthwords.utils.MainViewModel

class LearnListFragment : Fragment() {
    private lateinit var binding: FragmentLearnListBinding
    private val model: MainViewModel by activityViewModels()
    private lateinit var adapter: WordsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLearnListBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcList()

        model.mutableListWords.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

    //заполнение массива данными
   /* private fun fillWordsArray():ArrayList<WordsModel>{
        val tempArray = ArrayList<WordsModel>()
        resources.getStringArray(R.array.people).forEach {
            val wordArr = it.split("|")
            tempArray.add(WordsModel(wordArr[0],wordArr[1],null))

        }
        return tempArray
    }*/

    //передача заполненного массива в адаптер
    private fun initRcList() = with(binding){
        adapter = WordsAdapter()
        rcViewList.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        rcViewList.adapter = adapter

    }

    companion object {
        @JvmStatic
        fun newInstance() = LearnListFragment()
    }
}