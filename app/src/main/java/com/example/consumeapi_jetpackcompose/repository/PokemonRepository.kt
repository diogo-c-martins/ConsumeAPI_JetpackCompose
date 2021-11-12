package com.example.consumeapi_jetpackcompose.repository

import com.example.consumeapi_jetpackcompose.data.remote.PokeApi
import com.example.consumeapi_jetpackcompose.data.remote.responses.Pokemon
import com.example.consumeapi_jetpackcompose.data.remote.responses.PokemonList
import com.example.consumeapi_jetpackcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

//repository injected into ViewModel
@ActivityScoped //Live as long as activity does
class PokemonRepository @Inject constructor( //Inject dependencies to the constructor of repository
    private val api: PokeApi //Access to api instance
){
    //Implementation of API

    //Network Request #1
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e: Exception){
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    //Network Request #2
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e: Exception){
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }
}