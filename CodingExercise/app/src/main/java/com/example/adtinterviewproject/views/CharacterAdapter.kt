package com.example.adtinterviewproject.views

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.adtinterviewproject.R
import com.example.adtinterviewproject.network.data.Character

class CharacterAdapter : PagingDataAdapter<Character, CharacterViewHolder>(DIFF_CALLBACK) {

    companion object {
        private const val TAG = "CharacterAdapter"

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
                oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        Log.d(TAG, "onCreateViewHolder: ")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_row, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: position $position")
        getItem(position)?.let {
            holder.bindCharacter(it)
        }
    }
}
