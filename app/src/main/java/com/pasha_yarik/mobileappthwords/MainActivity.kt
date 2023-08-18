package com.pasha_yarik.mobileappthwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.pasha_yarik.mobileappthwords.FragmentsDictionaryY.FragmentTableLayoutY
import com.pasha_yarik.mobileappthwords.FragmentsHomeY.FragmentHomeMainY
import com.pasha_yarik.mobileappthwords.databinding.ActivityMainBinding
import com.pasha_yarik.mobileappthwords.fragmentsP.Learn1Fragment
import com.pasha_yarik.mobileappthwords.fragmentsP.LearnListFragment
import com.pasha_yarik.mobileappthwords.utils.FragmentManager
import com.pasha_yarik.mobileappthwords.utils.MainViewModel

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model.pref = getSharedPreferences("main", MODE_PRIVATE)
        model.progr = getSharedPreferences("main2", MODE_PRIVATE)
        model.cError = getSharedPreferences("main3", MODE_PRIVATE)


        //supportFragmentManager.beginTransaction().replace(R.id.placeHolder,Learn1Fragment.newInstance()).commit()
        //при запуске приложения сразу показывается фрагмент из восьми категорий
        FragmentManager.setFragment(Learn1Fragment.newInstance(), this)
        FragmentManager.currentFragment = Learn1Fragment()
        binding.imLearnACT.visibility = View.VISIBLE
        binding.imDictionaryACT.visibility = View.INVISIBLE
        binding.imHomeACT.visibility = View.INVISIBLE


        binding.bLearnAct.setOnClickListener {
            FragmentManager.setFragment(Learn1Fragment.newInstance(),this)
            FragmentManager.currentFragment = Learn1Fragment()

            binding.imLearnACT.visibility = View.VISIBLE
            binding.imDictionaryACT.visibility = View.INVISIBLE
            binding.imHomeACT.visibility = View.INVISIBLE

        }

        binding.bDictionaryAct.setOnClickListener {
            FragmentManager.setFragment(FragmentTableLayoutY.newInstance(),this)
            FragmentManager.currentFragment = FragmentTableLayoutY()

            binding.imLearnACT.visibility = View.INVISIBLE
            binding.imDictionaryACT.visibility = View.VISIBLE
            binding.imHomeACT.visibility = View.INVISIBLE
        }

        binding.bHomeAct.setOnClickListener {
            FragmentManager.setFragment(FragmentHomeMainY.newInstance(),this)
            FragmentManager.currentFragment = FragmentHomeMainY()

            binding.imLearnACT.visibility = View.INVISIBLE
            binding.imDictionaryACT.visibility = View.INVISIBLE
            binding.imHomeACT.visibility = View.VISIBLE
        }





    }

    //функция, которая запускается при нажатии кнопри "назад"
    override fun onBackPressed() {
        if(FragmentManager.currentFragment is Learn1Fragment) super.onBackPressed()//если основной экран, то закрываем приложение
        else {
            FragmentManager.setRequareFragment(Learn1Fragment.newInstance(),this) //если другой экран, то возщвращаемся на основной экран
            //binding.bnvNav.selectedItemId = R.id.bLearn // жёстко пофиксил баг броуди паши
            binding.imLearnACT.visibility = View.VISIBLE
            binding.imDictionaryACT.visibility = View.INVISIBLE
            binding.imHomeACT.visibility = View.INVISIBLE
        }
    }

}