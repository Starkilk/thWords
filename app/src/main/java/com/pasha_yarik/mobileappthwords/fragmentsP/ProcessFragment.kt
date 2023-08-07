package com.pasha_yarik.mobileappthwords.fragmentsP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pasha_yarik.mobileappthwords.R
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

        var count = 0

        processSlova(count)

        binding.bNextWord.setOnClickListener{
            count += 1
            if(count > resources.getStringArray(R.array.process_array).size - 1){

                requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.placeHolder,LearnListFragment.newInstance()).commit()
                FragmentManager.currentFragment = LearnListFragment()
                bottomNav?.visibility = View.VISIBLE
            }
            else{

                processSlova(count)

            }
        }

        bottomNav = activity?.findViewById(R.id.bnvNav)
        binding.imCloseProcess.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.placeHolder,LearnListFragment.newInstance()).commit()
            FragmentManager.currentFragment = LearnListFragment()
            bottomNav?.visibility = View.VISIBLE
        }
    }

    private fun processSlova(size: Int){
        val txt: Array<String> = resources.getStringArray(R.array.process_array)

        for(i in 0..size){

            val arr = txt[i].split("|")
            val adapter = ArrayAdapter<String>(requireContext(), R.layout.fragment_process, arr)

            binding.tvAnsWord.text = adapter.getItem(0)
            binding.bAnswer1.text = adapter.getItem(1)
            binding.bAnswer2.text = adapter.getItem(2)
            binding.bAnswer3.text = adapter.getItem(3)

        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = ProcessFragment()
    }
}


