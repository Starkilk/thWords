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
    var cError: SharedPreferences? = null
    fun savePref(key:String, value: Int){//индекс элемента в массиве
        pref?.edit()?.putInt(key, value)?.apply()
    }

    fun getPref(key:String): Int{//индекс элемента в массиве
        return pref?.getInt(key, 0) ?:0
    }


    fun saveProgr(key:String, value: Int){//заполненност progress bar
        progr?.edit()?.putInt(key, value)?.apply()
    }

    fun getProgr(key: String): Int {//заполненност progress bar
        return progr?.getInt(key, 0) ?: 0
    }


    fun saveCountError(key:String, value: Int){//заполненност progress bar
        cError?.edit()?.putInt(key, value)?.apply()
    }

    fun getCountError(key: String): Int {//заполненност progress bar
        return cError?.getInt(key, 0) ?: 0
    }
}