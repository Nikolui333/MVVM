package com.example.mvvm.data.api

import com.example.mvvm.data.models.FilmsApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("loadFilms.php")
    fun loadFilmsApi(): Call<ArrayList<FilmsApiModel>>
}