package com.example.rickandmortydb.service

import com.example.rickandmortydb.model.ResultsItem
import com.example.rickandmortydb.model.RickAndMortyModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacter(@Query("page") page: Int): Response<RickAndMortyModel>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<ResultsItem>
}