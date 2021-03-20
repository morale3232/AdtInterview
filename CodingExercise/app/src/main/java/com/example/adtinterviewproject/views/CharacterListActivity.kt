package com.example.adtinterviewproject.views

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.adtinterviewproject.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharacterListActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "CharacterListActivity"
    }

    private val characterAdapter = CharacterAdapter()

    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")

        characterListRecyclerView.adapter = characterAdapter

        fetchCharacters()
    }

    private fun fetchCharacters() {
        lifecycleScope.launch {
            Log.d(TAG, "fetchCharacters: Starting fetch")
            characterViewModel.fetchCharacters().collectLatest { characterData ->
            Log.d(TAG, "fetchCharacters: Received character data")
                characterAdapter.submitData(characterData)
            }
        }
    }
}
