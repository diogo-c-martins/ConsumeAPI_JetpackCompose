package com.example.consumeapi_jetpackcompose.data.remote

import com.example.consumeapi_jetpackcompose.data.remote.responses.Pokemon
import com.example.consumeapi_jetpackcompose.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        //Replace name dynamically
        @Path("name") name: String
    ): Pokemon
}