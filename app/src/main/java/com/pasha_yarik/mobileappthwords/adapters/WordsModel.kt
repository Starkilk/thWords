package com.pasha_yarik.mobileappthwords.adapters

data class WordsModel(
    var name:String,
    var count:String,
    var image:Int,
    var arrayProcess:Int,
    var statusProgres:Int? = null,
    var textInProgres:String? = null,
    var countErrors: Int? = null

)
