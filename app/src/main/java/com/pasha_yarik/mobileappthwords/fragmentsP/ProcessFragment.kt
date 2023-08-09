package com.pasha_yarik.mobileappthwords.fragmentsP

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pasha_yarik.mobileappthwords.R
import com.pasha_yarik.mobileappthwords.adapters.CategoryModel
import com.pasha_yarik.mobileappthwords.adapters.WordsAdapter
import com.pasha_yarik.mobileappthwords.adapters.WordsModel
import com.pasha_yarik.mobileappthwords.databinding.FragmentProcessBinding
import com.pasha_yarik.mobileappthwords.utils.FragmentManager
import com.pasha_yarik.mobileappthwords.utils.MainViewModel


class ProcessFragment : Fragment() {
    private lateinit var binding: FragmentProcessBinding
    private var bottomNav: BottomNavigationView? = null
    private val model: MainViewModel by activityViewModels()
    var wordList: Int? = null
    private var counterItem = 0
    private  var animator: ObjectAnimator? = null

    private var procc = 0
    private var startPb = 0

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

        counterItem = model.getPref(model.currentWord.toString())



        procc = model.getProgr(model.currentWord.toString())

        animator = ObjectAnimator.ofInt(binding.pbProcess,"progress",
            (startPb).toInt(),(procc).toInt())

        animator?.duration = 150
        animator?.start()


        Log.d("MyLog","${procc}")

        //при нажатии на крестик закрывается фрагмент и открывается предыдущий с выбором подкатегорий и навигация становится визибл
        binding.imCloseProcess.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.placeHolder, LearnListFragment.newInstance()).commit()
            FragmentManager.currentFragment = LearnListFragment()
            bottomNav?.visibility = View.VISIBLE
        }

        model.mutableArraWords.observe(viewLifecycleOwner) {
            wordList = it
            Log.d("Mylock","${wordList}")
            when (wordList) {
                0 -> processSlova(counterItem,resources.getStringArray(R.array.human))
                1 -> processSlova(counterItem,resources.getStringArray(R.array.mestoimeniya))
                2 -> processSlova(counterItem,resources.getStringArray(R.array.family))
                3 -> processSlova(counterItem,resources.getStringArray(R.array.body))
                4 -> processSlova(counterItem,resources.getStringArray(R.array.health))
                5 -> processSlova(counterItem,resources.getStringArray(R.array.good))
                6 -> processSlova(counterItem,resources.getStringArray(R.array.neitral))
                7 -> processSlova(counterItem,resources.getStringArray(R.array.bad))
                8 -> processSlova(counterItem,resources.getStringArray(R.array.work))
                9 -> processSlova(counterItem,resources.getStringArray(R.array.work_question))
                10 -> processSlova(counterItem,resources.getStringArray(R.array.clothes))
                11 -> processSlova(counterItem,resources.getStringArray(R.array.colors))
                12 -> processSlova(counterItem,resources.getStringArray(R.array.svoistva))
                13 -> processSlova(counterItem,resources.getStringArray(R.array.process))
                14 -> processSlova(counterItem,resources.getStringArray(R.array.digit))
                /*15 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                16 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                17 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                18 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                19 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                20 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                21 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                22 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                23 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                24 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                25 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                26 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                27 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                28 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                29 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                31 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                32 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                33 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                34 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                35 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                36 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                37 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                38 -> processSlova(0,resources.getStringArray(R.array.procc_array1))
                39 -> processSlova(0,resources.getStringArray(R.array.procc_array1))*/
            }

        }


    }



    private fun processSlova(size: Int, arr: Array<String>) {
        counterItem = size
        val array = arr
        var flag = 0


        val array1 = array[counterItem].split("|")
        val adapter = ArrayAdapter<String>(requireContext(), R.layout.fragment_process, array1)

        binding.bNextWord.isClickable = false

        val adaptAns = adapter.getItem(0).toString()
        val txtAnswer = adaptAns.substring(0,1).uppercase() + adaptAns.substring(1)

        val adaptB1Ans = adapter.getItem(1).toString()
        val txtB1Ans = adaptB1Ans.substring(0,1).uppercase() + adaptB1Ans.substring(1)

        val adaptB2Ans = adapter.getItem(2).toString()
        val txtB2Ans = adaptB2Ans.substring(0,1).uppercase() + adaptB2Ans.substring(1)

        val adaptB3Ans = adapter.getItem(3).toString()
        val txtB3Ans = adaptB3Ans.substring(0,1).uppercase() + adaptB3Ans.substring(1)

        val adaptB4Ans = adapter.getItem(4).toString()
        val txtB4Ans = adaptB4Ans.substring(0,1).uppercase() + adaptB4Ans.substring(1)

        binding.tvAnsWord.text = txtAnswer
        binding.bAnswer1.text = txtB1Ans
        binding.bAnswer2.text = txtB2Ans
        binding.bAnswer3.text = txtB3Ans
        binding.bAnswer4.text = txtB4Ans

        if (counterItem == arr.size - 1){

            binding.bNextWord.text = "Завершить"

        }

        binding.bAnswer1.setOnClickListener {
            val pos = adapter.getItem(5)!!
            val getText = adapter.getItem(pos.toInt()).toString()
            val txtBansw1 = getText.substring(0,1).uppercase() + getText.substring(1)

            if (binding.bAnswer1.text == txtBansw1) {

                binding.bAnswer1.setBackgroundColor(resources.getColor(R.color.nice_answer, null))
                binding.bAnswer2.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer3.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer4.setBackgroundColor(resources.getColor(R.color.background, null))

                binding.bAnswer2.isClickable = false
                binding.bAnswer3.isClickable = false
                binding.bAnswer4.isClickable = false

                flag = 1
            }
            else{
                binding.bAnswer1.setBackgroundColor(resources.getColor(R.color.bad_answer, null))
                binding.bAnswer2.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer3.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer4.setBackgroundColor(resources.getColor(R.color.background, null))
            }
        }

        binding.bAnswer2.setOnClickListener {
            val pos = adapter.getItem(5)!!
            val getText = adapter.getItem(pos.toInt()).toString()
            val txtBansw2 = getText.substring(0,1).uppercase() + getText.substring(1)

            if (binding.bAnswer2.text == txtBansw2) {

                binding.bAnswer1.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer2.setBackgroundColor(resources.getColor(R.color.nice_answer, null))
                binding.bAnswer3.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer4.setBackgroundColor(resources.getColor(R.color.background, null))

                binding.bAnswer1.isClickable = false
                binding.bAnswer3.isClickable = false
                binding.bAnswer4.isClickable = false

                flag = 1
            }
            else{
                binding.bAnswer1.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer2.setBackgroundColor(resources.getColor(R.color.bad_answer, null))
                binding.bAnswer3.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer4.setBackgroundColor(resources.getColor(R.color.background, null))
            }
        }

        binding.bAnswer3.setOnClickListener {
            val pos = adapter.getItem(5)!!
            val getText = adapter.getItem(pos.toInt()).toString()
            val txtBansw3 = getText.substring(0,1).uppercase() + getText.substring(1)

            if (binding.bAnswer3.text == txtBansw3) {

                binding.bAnswer1.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer2.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer3.setBackgroundColor(resources.getColor(R.color.nice_answer, null))
                binding.bAnswer4.setBackgroundColor(resources.getColor(R.color.background, null))

                binding.bAnswer1.isClickable = false
                binding.bAnswer2.isClickable = false
                binding.bAnswer4.isClickable = false

                flag = 1
            }
            else{
                binding.bAnswer1.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer2.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer3.setBackgroundColor(resources.getColor(R.color.bad_answer, null))
                binding.bAnswer4.setBackgroundColor(resources.getColor(R.color.background, null))
            }
        }

        binding.bAnswer4.setOnClickListener {
            val pos = adapter.getItem(5)!!
            val getText = adapter.getItem(pos.toInt()).toString()
            val txtBansw3 = getText.substring(0,1).uppercase() + getText.substring(1)

            if (binding.bAnswer4.text == txtBansw3) {

                binding.bAnswer1.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer2.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer3.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer4.setBackgroundColor(resources.getColor(R.color.nice_answer, null))

                binding.bAnswer1.isClickable = false
                binding.bAnswer2.isClickable = false
                binding.bAnswer3.isClickable = false

                flag = 1
            }
            else{
                binding.bAnswer1.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer2.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer3.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer4.setBackgroundColor(resources.getColor(R.color.bad_answer, null))
            }
        }

        binding.bNextWord.setOnClickListener {


            if (flag == 1) {
                counterItem += 1
                when(counterItem){

                    !in 0..arr.size -1 -> {

                        requireActivity().supportFragmentManager.beginTransaction()
                            .replace(R.id.placeHolder, LearnListFragment.newInstance()).commit()
                        FragmentManager.currentFragment = LearnListFragment()
                        bottomNav?.visibility = View.VISIBLE
                    }

                    in 0..arr.size - 1 -> {

                        startPb = procc
                        procc += 100 / (arr.size - 1)

                        animator = ObjectAnimator.ofInt(binding.pbProcess,"progress",
                            (startPb).toInt(),(procc).toInt())

                        animator!!.duration = 150
                        animator!!.start()

                        //binding.pbProcess.setProgress(procc)

                        binding.bAnswer1.setBackgroundColor(resources.getColor(R.color.background, null))
                        binding.bAnswer2.setBackgroundColor(resources.getColor(R.color.background, null))
                        binding.bAnswer3.setBackgroundColor(resources.getColor(R.color.background, null))
                        binding.bAnswer4.setBackgroundColor(resources.getColor(R.color.background, null))

                        processSlova(counterItem, arr)



                        Log.d("MyLog","${procc}")
                    }

                    else -> {}
                }

            }
            else{

            }

        }


    }

    override fun onDetach() {
        super.onDetach()
        model.savePref(model.currentWord.toString(),counterItem)
        model.saveProgr(model.currentWord.toString(),procc)
        Log.d("MyLog","${procc}")
    }
    /*binding.bNextWord.setOnClickListener {


        if (flag == 1) {
            siz += 1
            if (siz > arr.size - 1) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.placeHolder, LearnListFragment.newInstance()).commit()
                FragmentManager.currentFragment = LearnListFragment()
                bottomNav?.visibility = View.VISIBLE

            } else {

                val animator = ObjectAnimator.ofInt(binding.pbProcess,
                    "progress", startPb, procc)

                animator.duration = 600
                animator.start()

                //binding.pbProcess.setProgress(procc)

                binding.bAnswer1.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer2.setBackgroundColor(resources.getColor(R.color.background, null))
                binding.bAnswer3.setBackgroundColor(resources.getColor(R.color.background, null))

                processSlova(siz, arr)

                startPb = procc
                procc += 100 / (arr.size - 1)

            }

        }
        else{

        }
    }*/


    companion object {
            @JvmStatic
            fun newInstance() = ProcessFragment()
        }
}



