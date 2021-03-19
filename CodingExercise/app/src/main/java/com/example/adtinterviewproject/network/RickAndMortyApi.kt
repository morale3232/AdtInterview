package com.example.adtinterviewproject.network

import com.example.adtinterviewproject.network.data.AllCharacterInfo
import com.example.adtinterviewproject.network.data.Result
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {

    @GET("character")
    fun getCharacters(): Call<AllCharacterInfo>

    @GET("character/?page={pageNumber}")
    fun getCharactersPage(
        @Path("pageNumber") pageNumber: Int
    ): Call<JSONObject>

    @GET("character/{id}")
    fun getCharacter(
        @Path("id") id: Int
    ): Call<Result>
}
