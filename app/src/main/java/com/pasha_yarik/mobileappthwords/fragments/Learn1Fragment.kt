package com.pasha_yarik.mobileappthwords.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.pasha_yarik.mobileappthwords.MainActivity
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.databinding.FragmentLearn1Binding
import com.pasha_yarik.mobileappthwords.databinding.FragmentLearnListBinding
import com.pasha_yarik.mobileappthwords.utils.FragmentManager


class Learn1Fragment : Fragment() {
    private lateinit var binding: FragmentLearn1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLearn1Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button6.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.placeHolder, LearnListFragment.newInstance()).commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Learn1Fragment()
    }
}