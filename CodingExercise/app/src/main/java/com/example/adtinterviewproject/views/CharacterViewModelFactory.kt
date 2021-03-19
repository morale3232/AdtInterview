package com.example.adtinterviewproject.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adtinterviewproject.network.data.ResultDao

class CharacterViewModelFactory(
    private val resultDao: ResultDao
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RickAndMortyViewModel(resultDao) as T
    }
}
