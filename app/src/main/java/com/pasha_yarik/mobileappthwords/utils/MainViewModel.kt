package com.pasha_yarik.mobileappthwords.utils

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pasha_yarik.mobileappthwords.adapters.WordsModel

class MainViewModel:ViewModel() {
    val mutableListWords = MutableLiveData<ArrayList<WordsModel>>()
    val mutableArraWords = MutableLiveData<Int>()
    var pref: SharedPreferences? = null
    var currentWord = 0
    var progr: SharedPreferences? = null
    fun savePref(key:String, value: Int){
        pref?.edit()?.putInt(key, value)?.apply()
    }

    fun getPref(key:String): Int{
        return pref?.getInt(key, 0) ?:0
    }

    fun saveProgr(key:String, value: Float){
        progr?.edit()?.putFloat(key, value)?.apply()
    }

    fun getProgr(key: String): Float {
        return progr?.getFloat(key, -1f) ?: 0f
    }
}