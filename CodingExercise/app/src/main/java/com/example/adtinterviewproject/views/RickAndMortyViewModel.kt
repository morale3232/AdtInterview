package com.example.adtinterviewproject.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.example.adtinterviewproject.network.data.Result
import com.example.adtinterviewproject.network.data.ResultDao

class RickAndMortyViewModel(resultDao: ResultDao) : ViewModel() {

    val characterList: LiveData<PagedList<Result>> = resultDao.getAll().toLiveData(pageSize = 20)

}
