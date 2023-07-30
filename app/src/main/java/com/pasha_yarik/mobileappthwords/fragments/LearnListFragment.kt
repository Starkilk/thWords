package com.pasha_yarik.mobileappthwords.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.adapters.WordModel
import com.pasha_yarik.mobileappthwords.adapters.WordsAdapter
import com.pasha_yarik.mobileappthwords.databinding.FragmentLearnListBinding

class LearnListFragment : Fragment() {
    private lateinit var binding: FragmentLearnListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLearnListBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun fillWordsArray():ArrayList<WordModel>{
        val tempArray = ArrayList<WordModel>()
        resources.getStringArray(R.array.people).forEach {
            val wordArr = it.split("|")
            tempArray.add(WordModel(wordArr[0],wordArr[1],null))

        }
        return tempArray
    }

    private fun initRcView() = with(binding){
        val adapter = WordsAdapter()
        rcViewList.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        rcViewList.adapter = adapter
        adapter.submitList(fillWordsArray())
    }

    companion object {
        @JvmStatic
        fun newInstance() = LearnListFragment()
    }
}