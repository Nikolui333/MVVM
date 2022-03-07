package com.example.mvvm.data.repository.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.example.mvvm.data.localDB.FilmsDao
import com.example.mvvm.data.models.FilmsModel
import com.example.mvvm.data.repository.dataSource.FilmsDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmsDataSourceIMPL (private val dao: FilmsDao):
    FilmsDataSource {


    override fun insert(filmsModel: FilmsModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(filmsModel)}
    }

    override fun loadFilms(): LiveData<List<FilmsModel>> {
        return dao.loadFilms()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }



}