package com.example.adtinterviewproject.network

import android.util.Log
import androidx.paging.PagingSource
import com.example.adtinterviewproject.network.data.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Suppress("BlockingMethodInNonBlockingContext")
class CharacterPagingSource(private val rickAndMortyService: RickAndMortyService) :
    PagingSource<String, Character>() {

    private val TAG = "CharacterPagingSource"

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Character> {
        Log.d(TAG, "load: ${params.loadSize}")
        return try {

            val response = withContext(Dispatchers.IO) {
                rickAndMortyService.getCharacters().execute()
            }

            val characters = response.body()?.results
            Log.d(TAG, "load: Received ${characters?.size} characters")

            LoadResult.Page(
                characters ?: listOf(),
                null,
                null
            )

        } catch (exception: Exception) {
            Log.e(TAG, "load: Caught exception", exception)
            return LoadResult.Error(exception)
        }
    }
}
