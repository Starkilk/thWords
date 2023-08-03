package com.pasha_yarik.mobileappthwords.FragmentsDictionaryY

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.pasha_yarik.mobileappthwords.R
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pasha_yarik.mobileappthwords.adapter_dictionaryY.SlovAdapterY
import com.pasha_yarik.mobileappthwords.adapter_dictionaryY.SlovDataModelY
import com.pasha_yarik.mobileappthwords.databinding.FragmentFragSlovAllYBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragSlovAllY : Fragment() {
    lateinit var binding: FragmentFragSlovAllYBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFragSlovAllYBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SlovAdapterY()
        initRcView()

    }

    private fun initRcView() = with(binding){
        val adapter = SlovAdapterY()
        RcViewAll.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        RcViewAll.adapter = adapter
        adapter.submitList(slovInicialization())
    }

    private fun slovInicialization(): ArrayList<SlovDataModelY>{
        val englArray = resources.getStringArray(R.array.English_words_all)
        val russlArray = resources.getStringArray(R.array.Russian_words_all)
        val tArray = ArrayList<SlovDataModelY>()
        val size = resources.getStringArray(R.array.Russian_words_all).size - 1

        for(i in 0..size) {
            tArray.add(SlovDataModelY(englArray[i], russlArray[i]))
        }
        return tArray
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragSlovAllY()
    }

}