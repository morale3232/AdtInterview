package com.example.adtinterviewproject.network.data

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ResultDao {

    @Query("SELECT *")
    fun getAll(): DataSource.Factory<Int, Character>

}
