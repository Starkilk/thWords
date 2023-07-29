package com.pasha_yarik.mobileappthwords.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pasha_yarik.mobileappthwords.R
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



    companion object {
        @JvmStatic
        fun newInstance() = LearnListFragment()
    }
}