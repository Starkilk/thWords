package com.pasha_yarik.mobileappthwords.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.pasha_yarik.mobileappthwords.R


object FragmentManager {
    var currentFragment: Fragment? = null

    fun setRequareFragment(newReqFragment: Fragment, context: Context) {
        val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeHolder, newReqFragment)
        transaction.commit()

        currentFragment = newReqFragment
    }

    fun setFragment(newFragment: Fragment, act:AppCompatActivity){
        val transaction = act.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeHolder, newFragment)
        transaction.commit()

        currentFragment = newFragment
    }


}