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

    private fun slovInicialization(): ArrayList<SlovDataModelY> {

        val tempArray = ArrayList<SlovDataModelY>()
        resources.getStringArray(R.array.words).forEach {
            val wordArr = it.split("|")
            tempArray.add(SlovDataModelY(wordArr[0],wordArr[1]))

        }
        return tempArray
    }


    companion object {

        @JvmStatic
        fun newInstance() = FragSlovAllY()
    }

}