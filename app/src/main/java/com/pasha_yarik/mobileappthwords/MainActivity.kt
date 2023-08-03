package com.pasha_yarik.mobileappthwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pasha_yarik.mobileappthwords.FragmentsDictionaryY.FragmentTableLayoutY
import com.pasha_yarik.mobileappthwords.FragmentsHomeY.FragmentHomeMainY
import com.pasha_yarik.mobileappthwords.databinding.ActivityMainBinding
import com.pasha_yarik.mobileappthwords.databinding.FragmentHomeMainYBinding
import com.pasha_yarik.mobileappthwords.fragments.Learn1Fragment
import com.pasha_yarik.mobileappthwords.fragments.LearnListFragment
import com.pasha_yarik.mobileappthwords.utils.FragmentManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //supportFragmentManager.beginTransaction().replace(R.id.placeHolder,Learn1Fragment.newInstance()).commit()
        //при запуске приложения сразу показывается фрагмент из восьми категорий
        FragmentManager.setFragment(Learn1Fragment.newInstance(), this)

        binding.bnvNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bLearn -> {FragmentManager.setFragment(Learn1Fragment.newInstance(), this)}

                R.id.bDictionary -> {FragmentManager.setFragment(FragmentTableLayoutY(), this)}

                R.id.bHome -> {FragmentManager.setFragment(FragmentHomeMainY.newInstance(),this)}
            }
            true
        }
    }

    //функция, которая запускается при нажатии кнопри "назад"
    override fun onBackPressed() {
        if(FragmentManager.currentFragment is Learn1Fragment) super.onBackPressed()//если основной экран, то закрываем приложение
        else FragmentManager.setRequareFragment(Learn1Fragment.newInstance(),this)//если другой экран, то возщвращаемся на основной экран
    }

}