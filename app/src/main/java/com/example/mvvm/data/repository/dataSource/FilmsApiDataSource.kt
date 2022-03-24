package com.example.mvvm.data.repository.dataSource

import android.content.Context
import com.agrawalsuneet.dotsloader.loaders.ZeeLoader

interface FilmsApiDataSource {

    fun startMigration(context: Context, loader: ZeeLoader)
}