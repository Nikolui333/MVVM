package com.example.mvvm.data.repository.dataSource

import android.content.Context

interface FilmsApiDataSource {

    fun startMigration(context: Context)
}