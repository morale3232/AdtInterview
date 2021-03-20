package com.example.adtinterviewproject.network.data

import androidx.room.Entity

@Entity
data class AllCharacterInfo(
    val info: Info,
    val results: List<Character>
)
