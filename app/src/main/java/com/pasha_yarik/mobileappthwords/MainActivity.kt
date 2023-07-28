package com.pasha_yarik.mobileappthwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pasha_yarik.mobileappthwords.databinding.ActivityMainBinding
import com.pasha_yarik.mobileappthwords.fragments.Learn1Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.placeHolder,Learn1Fragment.newInstance()).commit()
    }
}