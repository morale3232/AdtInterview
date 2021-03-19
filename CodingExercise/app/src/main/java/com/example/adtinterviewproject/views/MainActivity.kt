package com.example.adtinterviewproject.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adtinterviewproject.R

class MainActivity : AppCompatActivity() {

    private val characterAdapter = CharacterAdapter()

    private val viewModel: RickAndMortyViewModel by viewModels()

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.characterListRecyclerView)
        recyclerView.apply {
            adapter = characterAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.characterList.observe(this, { resultList ->
            characterAdapter.submitList(resultList)
        })
    }
}
