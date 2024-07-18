package com.example.rickandmortydb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortydb.model.ResultsItem
import com.example.rickandmortydb.model.RickAndMortyModel
import com.example.rickandmortydb.repository.RickAndMortyRepository
import kotlinx.coroutines.launch

class RickAndMortyViewModel() : ViewModel() {

    private val _allCharacter = MutableLiveData<RickAndMortyModel?>()
    private val _character = MutableLiveData<ResultsItem?>()
    private val _loadingDialog = MutableLiveData<Boolean>()

    var page = 1
    var maxPage = 100

    val allCharacter: LiveData<RickAndMortyModel?>
        get() =
            _allCharacter

    val character: LiveData<ResultsItem?>
        get() =
            _character

    val loadingDialog: LiveData<Boolean> get() = _loadingDialog

    private val repository = RickAndMortyRepository()

    fun getCharacter() {
        _loadingDialog.value = true
        viewModelScope.launch {
            val resultData = repository.getCharacter(page)
            if (resultData.isSuccessful)
                _allCharacter.value = resultData.body()
            _loadingDialog.value = false
        }
    }

    fun getCharacterById(id: Int) {
        _loadingDialog.value = true
        viewModelScope.launch {
            val resultData = repository.getCharacterById(id)
            if (resultData.isSuccessful)
                _character.value = resultData.body()
            _loadingDialog.value = false
        }
    }

}