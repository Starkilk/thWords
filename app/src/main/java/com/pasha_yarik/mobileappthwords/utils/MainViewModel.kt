package com.pasha_yarik.mobileappthwords.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pasha_yarik.mobileappthwords.adapters.WordsModel

class MainViewModel:ViewModel() {
    val mutableListWords = MutableLiveData<ArrayList<WordsModel>>()
}