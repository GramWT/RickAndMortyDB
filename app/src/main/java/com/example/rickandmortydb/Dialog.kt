package com.example.rickandmortydb

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.Window

object Dialog {

    fun createLoadingDialog(context: Context): Dialog {
        val dialog = android.app.Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val view = LayoutInflater.from(context).inflate(R.layout.widget_loading_dialog, null)
        dialog.setContentView(view)
        dialog.setCancelable(false)
        return dialog
    }
}