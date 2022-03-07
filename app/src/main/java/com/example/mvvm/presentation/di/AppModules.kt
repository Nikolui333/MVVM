package com.example.mvvm.presentation.di

import androidx.room.Room
import com.example.mvvm.data.localDB.LocalDB
import com.example.mvvm.data.repository.dataSource.FilmsApiDataSource
import com.example.mvvm.data.repository.dataSource.FilmsDataSource
import com.example.mvvm.data.repository.dataSourceIMPL.FilmsApiDataSourceIMPL
import com.example.mvvm.data.repository.dataSourceIMPL.FilmsDataSourceIMPL
import com.example.mvvm.data.repository.repository.FilmsRepository
import com.example.mvvm.domain.repository.FilmsCall
import com.example.mvvm.domain.useCase.FilmsUseCase
import com.example.mvvm.presentation.FilmsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleFilms = module{

    single {
        Room.databaseBuilder(androidContext(), LocalDB::class.java,
            "localDB").build()
    }

    single { get<LocalDB>().filmsDao }


    single<FilmsDataSource> {
        FilmsDataSourceIMPL(
            get()
        )
    }

    single<FilmsApiDataSource> {
        FilmsApiDataSourceIMPL(
            get()
        )
    }

    single<FilmsCall> { FilmsRepository(get(),get()) }

    single { FilmsUseCase(get()) }

    viewModel { FilmsViewModel(get()) }

}