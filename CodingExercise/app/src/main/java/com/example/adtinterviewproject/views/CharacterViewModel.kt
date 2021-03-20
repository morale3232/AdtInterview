package com.example.adtinterviewproject.views

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.adtinterviewproject.network.CharacterRepo
import com.example.adtinterviewproject.network.data.Character
import kotlinx.coroutines.flow.Flow

class CharacterViewModel(application: Application) : AndroidViewModel(application) {

    private val TAG = "CharacterViewModel"

    private val characterRepo = CharacterRepo()


    fun fetchCharacters(): Flow<PagingData<Character>> {
        Log.d(TAG, "fetchCharacters: ")
        return characterRepo.fetchCharacters().cachedIn(viewModelScope)
    }
}
