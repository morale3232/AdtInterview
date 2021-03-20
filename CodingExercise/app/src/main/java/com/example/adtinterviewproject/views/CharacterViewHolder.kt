package com.example.adtinterviewproject.views

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.adtinterviewproject.network.data.Character
import kotlinx.android.synthetic.main.character_row.view.*

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val TAG = "CharacterViewHolder"

    private val nameTextView = itemView.characterNameTextView
    private val statusTextView = itemView.characterStatusTextView

    fun bindCharacter(character: Character) {
        Log.d(TAG, "bindCharacter: ${character.name}")
        nameTextView.text = character.name
        statusTextView.text = character.status
    }
}
