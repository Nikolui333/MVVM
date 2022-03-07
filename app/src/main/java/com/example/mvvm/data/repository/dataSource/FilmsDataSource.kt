package com.example.mvvm.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.example.mvvm.data.models.FilmsModel

interface FilmsDataSource {

    fun insert(filmsModel: FilmsModel)

    fun loadFilms(): LiveData<List<FilmsModel>>

    suspend fun clear()

}