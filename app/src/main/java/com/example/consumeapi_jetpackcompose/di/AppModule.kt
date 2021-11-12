package com.example.consumeapi_jetpackcompose.di

import com.example.consumeapi_jetpackcompose.data.remote.PokeApi
import com.example.consumeapi_jetpackcompose.repository.PokemonRepository
import com.example.consumeapi_jetpackcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Module for injection, needed for exemplify how we construct dependencies,
//- so dagger be able to inject data into classes
@Module
@InstallIn(SingletonComponent::class)  //Singleton, dependencies in this AppModule
//- will live as long as our application does.
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokeApi(): PokeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }

}