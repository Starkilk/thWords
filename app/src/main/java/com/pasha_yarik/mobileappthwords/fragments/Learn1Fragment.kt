package com.pasha_yarik.mobileappthwords.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.databinding.FragmentLearn1Binding


class Learn1Fragment : Fragment() {
    private lateinit var binding: FragmentLearn1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_learn1, container, false)
    }



    companion object {
        @JvmStatic
        fun newInstance() = Learn1Fragment()
    }
}