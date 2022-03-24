package com.example.mvvm.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.agrawalsuneet.dotsloader.loaders.ZeeLoader
import com.example.mvvm.data.models.FilmsModel
import com.example.mvvm.domain.repository.FilmsCall


class FilmsUseCase (private val filmsCall: FilmsCall) {


    fun loadFilms(): LiveData<List<FilmsModel>> {

        return filmsCall.loadFilms()

    }

    suspend fun startMigration (context: Context, loader: ZeeLoader) {

        filmsCall.startMigration(context, loader)

    }

}