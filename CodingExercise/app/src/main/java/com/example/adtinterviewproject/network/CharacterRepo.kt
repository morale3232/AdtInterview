package com.example.adtinterviewproject.network

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.adtinterviewproject.network.data.Character
import kotlinx.coroutines.flow.Flow

class CharacterRepo {

    private val TAG = "CharacterRepo"

    private val characterService =
        CharacterService.getRetrofit().create(RickAndMortyService::class.java)

    fun fetchCharacters(): Flow<PagingData<Character>> {
        Log.d(TAG, "fetchCharacters: ")
        return Pager(
            PagingConfig(pageSize = 20, enablePlaceholders = false)
        ) {
            CharacterPagingSource(characterService)
        }.flow
    }
}
