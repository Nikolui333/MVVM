package com.example.mvvm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.data.models.FilmsModel
import com.example.mvvm.databinding.FilmItemBinding
import com.squareup.picasso.Picasso

class FilmAdapter : RecyclerView.Adapter<FilmAdapter.FilmHolder>() {

    private val filmsList = ArrayList<FilmsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: FilmItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.film_item, parent, false)
        return FilmHolder(binding)
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        holder.bind(filmsList[position])
    }

    fun setList(films: List<FilmsModel>) {
        filmsList.clear()
        filmsList.addAll(films)

    }


    class FilmHolder(val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            films: FilmsModel
        ) {

            val getImage = films.image
            Picasso.get().load(getImage).into(binding.imageFilm)
            binding.idFilm.text = films.id.toString()
            binding.nameFilm.text = films.name

        }

    }
}