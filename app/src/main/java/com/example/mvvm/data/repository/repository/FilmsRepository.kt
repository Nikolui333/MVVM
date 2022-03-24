package com.example.mvvm.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.agrawalsuneet.dotsloader.loaders.ZeeLoader
import com.example.mvvm.data.models.FilmsModel
import com.example.mvvm.data.repository.dataSource.FilmsApiDataSource
import com.example.mvvm.data.repository.dataSource.FilmsDataSource
import com.example.mvvm.domain.repository.FilmsCall

class FilmsRepository (private val filmsApiDataSource: FilmsApiDataSource,
                       private val filmsDataSource: FilmsDataSource
): FilmsCall {

    override fun loadFilms(): LiveData<List<FilmsModel>> {
        return filmsDataSource.loadFilms()
    }

    override suspend fun startMigration(context: Context, loader: ZeeLoader) {
        filmsDataSource.clear()
        filmsApiDataSource.startMigration(context, loader)
    }
}