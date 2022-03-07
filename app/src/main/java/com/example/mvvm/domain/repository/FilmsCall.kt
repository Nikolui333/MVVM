package com.example.mvvm.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvm.data.models.FilmsModel

interface FilmsCall {

    fun loadFilms(): LiveData<List<FilmsModel>>

    suspend fun startMigration(context: Context)

}
