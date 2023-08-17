package com.pasha_yarik.mobileappthwords.FragmentsHomeY

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.databinding.FragmentHomeMainYBinding
import com.pasha_yarik.mobileappthwords.fragmentsP.DescriptionFragment
import com.pasha_yarik.mobileappthwords.utils.DialogManager
import com.pasha_yarik.mobileappthwords.utils.FragmentManager
import com.pasha_yarik.mobileappthwords.utils.MainViewModel


class FragmentHomeMainY : Fragment() {
    lateinit var binding: FragmentHomeMainYBinding
    private val model: MainViewModel by activityViewModels()
    private var homeProgress = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentHomeMainYBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for(i in 0..39){
            val modelProgrss = model.getPref(i.toString())
            homeProgress += modelProgrss
        }

        binding.pbInHomeView.progress = homeProgress
        val tmp = "${homeProgress / 2} из 1000"
        binding.tvCountWordsHome.text = tmp


        binding.tvOprilojenii.setOnClickListener {

            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.placeHolder,DescriptionFragment.newInstance()).commit()
            FragmentManager.currentFragment = DescriptionFragment()
        }

        binding.bSignGoogle.setOnClickListener {
            DialogManager.showNedodel(
                activity as AppCompatActivity,R.string.dialog_ne_rabotaet,R.string.dialog_dont_worked
            )
        }

    }



    companion object {
        @JvmStatic
        fun newInstance() = FragmentHomeMainY()
    }
}
