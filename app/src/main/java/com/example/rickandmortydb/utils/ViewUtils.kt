package com.example.rickandmortydb.utils

import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import com.example.rickandmortydb.R

object ViewUtils {

    fun View.visible() {
        this.visibility = View.VISIBLE
    }

    fun View.invisible() {
        this.visibility = View.INVISIBLE
    }

    fun View.gone() {
        this.visibility = View.GONE
    }

    fun View.tintColor(context: Context,color: Int) {
        this.backgroundTintList =
            ContextCompat.getColorStateList(context, color)
    }
}