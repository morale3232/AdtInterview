package com.example.adtinterviewproject.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyService {

    companion object {
        private val BASE_URL: String = "https://rickandmortyapi.com/api/"


        fun getRetrofit() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}
