package com.example.mvvm.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.data.models.FilmsModel

@Database(entities = [FilmsModel::class], version = 1)
abstract class LocalDB: RoomDatabase() {
    abstract val filmsDao: FilmsDao
}