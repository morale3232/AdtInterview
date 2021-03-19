package com.example.adtinterviewproject.views

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.adtinterviewproject.R
import com.example.adtinterviewproject.network.data.Result

class CharacterAdapter : PagedListAdapter<Result, CharacterViewHolder>(DIFF_CALLBACK) {

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
                oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = View.inflate(parent.context, R.layout.character_row, parent)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun submitList(resultList: PagedList<Result>?) {

    }
}
