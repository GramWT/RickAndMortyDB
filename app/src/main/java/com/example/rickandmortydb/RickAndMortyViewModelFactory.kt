package com.example.rickandmortydb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortydb.viewmodel.RickAndMortyViewModel

class RickAndMortyViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RickAndMortyViewModel::class.java)) {
            return RickAndMortyViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}