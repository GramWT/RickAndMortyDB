package com.example.rickandmortydb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortydb.model.RickAndMortyModel
import com.example.rickandmortydb.repository.RickAndMortyRepository
import kotlinx.coroutines.launch

class RickAndMortyViewModel() : ViewModel() {

    private val _allCharacter = MutableLiveData<RickAndMortyModel?>()

    var page = 1
    var maxPage = 100

    val allCharacter: LiveData<RickAndMortyModel?>
        get() =
            _allCharacter

    private val repository = RickAndMortyRepository()

    fun getCharacter() {
        viewModelScope.launch {
            val resultData = repository.getCharacter(page)
            if (resultData.isSuccessful)
                _allCharacter.value = resultData.body()
        }
    }

}