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

    fun showNedodel(context: Context, mId: Int,stringId: Int){
        val builder2 = AlertDialog.Builder(context)
        var dialig2: AlertDialog? = null
        builder2.setMessage(mId)
        builder2.setTitle(stringId)

        builder2.setNegativeButton(R.string.dialog_ok){_,_ ->
            dialig2?.dismiss()
        }
        dialig2 = builder2.create()
        dialig2.show()
    }

    interface ListenerClear{
        fun  onClick()
    }
}