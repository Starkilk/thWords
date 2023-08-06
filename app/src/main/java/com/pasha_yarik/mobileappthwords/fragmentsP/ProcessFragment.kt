package com.pasha_yarik.mobileappthwords.fragmentsP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.adapters.CategoryModel
import com.pasha_yarik.mobileappthwords.adapters.WordsAdapter
import com.pasha_yarik.mobileappthwords.adapters.WordsModel
import com.pasha_yarik.mobileappthwords.databinding.FragmentProcessBinding
import com.pasha_yarik.mobileappthwords.utils.FragmentManager


class ProcessFragment : Fragment() {
    private lateinit var binding: FragmentProcessBinding
    private var bottomNav: BottomNavigationView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProcessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNav = activity?.findViewById(R.id.bnvNav)

        binding.imCloseProcess.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.placeHolder,LearnListFragment.newInstance()).commit()
            FragmentManager.currentFragment = LearnListFragment()
            bottomNav?.visibility = View.VISIBLE
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProcessFragment()
    }
}


