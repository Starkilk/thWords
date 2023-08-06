package com.pasha_yarik.mobileappthwords.fragmentsP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.databinding.FragmentProcessBinding


class ProcessFragment : Fragment() {
    private lateinit var binding: FragmentProcessBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProcessBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProcessFragment()
    }
}