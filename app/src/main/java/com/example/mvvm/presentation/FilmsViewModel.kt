package com.example.mvvm.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agrawalsuneet.dotsloader.loaders.ZeeLoader
import com.example.mvvm.domain.useCase.FilmsUseCase
import kotlinx.coroutines.launch

class FilmsViewModel (private val filmsUseCase: FilmsUseCase):
    ViewModel() {

    val loadFilms = filmsUseCase.loadFilms()


    fun migration(context: Context, loader: ZeeLoader) = viewModelScope.launch {
        filmsUseCase.startMigration(context, loader)

    }

}