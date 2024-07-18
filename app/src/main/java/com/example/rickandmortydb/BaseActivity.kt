package com.example.rickandmortydb

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortydb.viewmodel.RickAndMortyViewModel

open class BaseActivity : AppCompatActivity() {

    private var loadingDialog: android.app.Dialog? = null

    private val viewModel: RickAndMortyViewModel by viewModels {
        RickAndMortyViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = resources.getColor(R.color.black_36, theme)

        attachObserver()

        loadingDialog = Dialog.createLoadingDialog(this)
    }

    private fun attachObserver() {
        viewModel.loadingDialog.observe(this) {
            if (it) {
                loadingDialog?.show()
            } else {
                if (loadingDialog?.isShowing == true) {
                    loadingDialog?.dismiss()
                }
            }
        }
    }
}