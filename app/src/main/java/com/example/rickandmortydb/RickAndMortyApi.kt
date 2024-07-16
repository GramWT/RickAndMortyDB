package com.example.rickandmortydb

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacter(@Query("page") page: Int): Response<RickAndMortyModel>
}