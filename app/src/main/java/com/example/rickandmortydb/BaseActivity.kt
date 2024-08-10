package com.example.rickandmortydb

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortydb.viewmodel.RickAndMortyViewModel

open class BaseActivity : AppCompatActivity() {

    var loadingDialog: android.app.Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = resources.getColor(R.color.black_36, theme)

        attachObserver()

        loadingDialog = Dialog.createLoadingDialog(this)
    }

    private fun attachObserver() {
    }
}