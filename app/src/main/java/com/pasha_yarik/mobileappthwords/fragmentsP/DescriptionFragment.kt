package com.pasha_yarik.mobileappthwords.fragmentsP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pasha_yarik.mobileappthwords.FragmentsHomeY.FragmentHomeMainY
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.databinding.FragmentOprilojeniiBinding
import com.pasha_yarik.mobileappthwords.utils.FragmentManager


class DescriptionFragment : Fragment() {
    private lateinit var binding: FragmentOprilojeniiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOprilojeniiBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imBackHome.setOnClickListener {

            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.placeHolder,FragmentHomeMainY.newInstance()).commit()
            FragmentManager.currentFragment = FragmentHomeMainY()
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = DescriptionFragment()
    }
}