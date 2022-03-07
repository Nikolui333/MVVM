package com.example.mvvm.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films_data_table")
class FilmsModel (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "films_id")
    val id:Int,

    @ColumnInfo(name = "films_name")
    val name:String,

    @ColumnInfo(name = "films_image")
    val image:String

)