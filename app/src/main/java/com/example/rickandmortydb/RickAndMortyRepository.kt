package com.example.rickandmortydb

import retrofit2.Response

class RickAndMortyRepository {

    suspend fun getCharacter(page:Int): Response<RickAndMortyModel> {
        return RetrofitInstance.api.getCharacter(page)
    }
}