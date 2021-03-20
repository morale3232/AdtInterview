package com.example.adtinterviewproject.network

import com.example.adtinterviewproject.network.data.AllCharacterInfo
import com.example.adtinterviewproject.network.data.Character
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {

    @GET("character")
    fun getCharacters(): Call<AllCharacterInfo>

    @GET("character/?page={pageNumber}")
    fun getCharactersPage(
        @Path("pageNumber") pageNumber: Int
    ): Call<JSONObject>

    @GET("character/{id}")
    fun getCharacter(
        @Path("id") id: Int
    ): Call<Character>
}
