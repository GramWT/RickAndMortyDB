package com.example.rickandmortydb.repository

import com.example.rickandmortydb.model.ResultsItem
import com.example.rickandmortydb.model.RickAndMortyModel
import com.example.rickandmortydb.retrofit.RetrofitInstance
import retrofit2.Response

class RickAndMortyRepository {

    suspend fun getCharacter(page:Int): Response<RickAndMortyModel> {
        return RetrofitInstance.api.getCharacter(page)
    }

    suspend fun getCharacterById(id:Int): Response<ResultsItem> {
        return RetrofitInstance.api.getCharacterById(id)
    }
}