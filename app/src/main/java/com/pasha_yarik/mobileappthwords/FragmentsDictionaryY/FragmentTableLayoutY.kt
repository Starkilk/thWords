package com.pasha_yarik.mobileappthwords.FragmentsDictionaryY

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pasha_yarik.mobileappthwords.R
import com.google.android.material.tabs.TabLayout
import com.pasha_yarik.mobileappthwords.databinding.FragmentTableLayoutYBinding


class FragmentTableLayoutY : Fragment() {
    private lateinit var binding: FragmentTableLayoutYBinding
    val FragList = listOf(FragSlovAllY.newInstance(),FragSlovMyY.newInstance())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTableLayoutYBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frame_slov, FragSlovAllY.newInstance()).commit()


        binding.tbLay.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_slov, FragList[tab?.position!!]).commit()

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_slov, FragList[tab?.position!!] ).commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }


    companion object {
        @JvmStatic
        fun newInstance() = FragmentTableLayoutY()

    }

}

