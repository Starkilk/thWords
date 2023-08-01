package com.pasha_yarik.mobileappthwords.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    val mutableListWords = MutableLiveData<String>()
}