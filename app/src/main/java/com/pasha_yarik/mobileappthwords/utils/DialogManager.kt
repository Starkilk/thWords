package com.pasha_yarik.mobileappthwords.utils

import android.app.AlertDialog
import android.content.Context
import com.pasha_yarik.mobileappthwords.R

object DialogManager {
    fun showDialog(context: Context, mId: Int, listener:ListenerClear){
        val builder = AlertDialog.Builder(context)
        var dialig: AlertDialog? = null
        builder.setMessage(mId)
        builder.setTitle(R.string.repeat_category)

        builder.setPositiveButton(R.string.reset_category){_,_ ->
            listener.onClick()
            dialig?.dismiss()


        }

        builder.setNegativeButton(R.string.cancel_category){_,_ ->
            dialig?.dismiss()
        }
        dialig = builder.create()
        dialig.show()
    }


    interface ListenerClear{
        fun  onClick()
    }
}