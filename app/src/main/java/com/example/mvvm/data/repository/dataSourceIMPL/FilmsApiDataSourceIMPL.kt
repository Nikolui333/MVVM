package com.example.mvvm.data.repository.dataSourceIMPL

import android.content.Context
import android.view.View
import android.widget.Toast
import com.agrawalsuneet.dotsloader.loaders.ZeeLoader
import com.example.mvvm.data.api.ApiClient
import com.example.mvvm.data.models.FilmsApiModel
import com.example.mvvm.data.models.FilmsModel
import com.example.mvvm.data.repository.dataSource.FilmsApiDataSource
import com.example.mvvm.data.repository.dataSource.FilmsDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsApiDataSourceIMPL (private val filmsDataSource: FilmsDataSource):
    FilmsApiDataSource {



    override fun startMigration (context: Context, loader: ZeeLoader) {

        val call = ApiClient.instance?.api?.loadFilmsApi()
        call?.enqueue(object: Callback<ArrayList<FilmsApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<FilmsApiModel>>,
                response: Response<ArrayList<FilmsApiModel>>
            ) {


                var loadFilms: ArrayList<FilmsApiModel>? = null

                loadFilms?.clear()

                loadFilms = (response.body() as ArrayList<FilmsApiModel>?)!!

                for (audit in loadFilms) {

                    audit.id?.let {
                        FilmsModel(
                            it,
                            audit.name.toString(),
                            audit.image.toString()
                        )
                    }?.let {
                        filmsDataSource.insert(
                            it
                        )
                    }

                }

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()

                loader.visibility = View.GONE
            }

            override fun onFailure(call: Call<ArrayList<FilmsApiModel>>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }
}