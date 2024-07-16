package com.example.rickandmortydb.service

import com.example.rickandmortydb.model.RickAndMortyModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacter(@Query("page") page: Int): Response<RickAndMortyModel>
}