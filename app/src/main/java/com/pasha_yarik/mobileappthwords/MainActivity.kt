package com.pasha_yarik.mobileappthwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pasha_yarik.mobileappthwords.databinding.ActivityMainBinding
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
    }
}