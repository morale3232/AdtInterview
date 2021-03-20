package com.example.adtinterviewproject.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterService {

    companion object {
        private const val BASE_URL: String = "https://rickandmortyapi.com/api/"


        fun getRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}
