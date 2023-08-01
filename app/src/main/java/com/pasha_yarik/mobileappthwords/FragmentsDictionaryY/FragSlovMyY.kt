package com.pasha_yarik.mobileappthwords.FragmentsDictionaryY

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pasha_yarik.mobileappthwords.adapter_dictionaryY.SlovAdapterY
import com.pasha_yarik.mobileappthwords.adapter_dictionaryY.SlovDataModelY
import com.pasha_yarik.mobileappthwords.databinding.FragmentFragSlovMyYBinding


class FragSlovMyY : Fragment() {
    private lateinit var binding: FragmentFragSlovMyYBinding

    val EnglishWordList = ArrayList<String>()
    val RussianWordList = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFragSlovMyYBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.cardView.setOnClickListener{
            binding.cvAddWord.visibility = View.VISIBLE
        }


        binding.bAdd.setOnClickListener{
            val englmy = binding.tvEnglMy.text
            EnglishWordList.add(englmy.toString())

            val rusmy = binding.tvRusMy.text
            RussianWordList.add(rusmy.toString())

            binding.cvAddWord.visibility = View.INVISIBLE

            initRcView()

            binding.tvEnglMy.text = null
            binding.tvRusMy.text = null
        }

    }

    private fun initRcView() = with(binding){
        val adapter = SlovAdapterY()
        RcViewMy.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        RcViewMy.adapter = adapter
        adapter.submitList(slovInicialization(EnglishWordList, RussianWordList))
    }

    private fun slovInicialization(engl: ArrayList<String>, rus: ArrayList<String>): ArrayList<SlovDataModelY>{
        val englArray = engl
        val russlArray = rus

        val tArray = ArrayList<SlovDataModelY>()

        val size = RussianWordList.size - 1

        for(i in 0..size) {
            tArray.add(SlovDataModelY(englArray[i], russlArray[i]))
        }

        return tArray
    }



    companion object {

        @JvmStatic
        fun newInstance() = FragSlovMyY()
    }

}