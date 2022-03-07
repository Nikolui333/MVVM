package com.example.mvvm.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import com.example.mvvm.databinding.FragmentFilmsBinding


class Films : Fragment() {

    private var binding: FragmentFilmsBinding? = null
    private var filmAdapter: FilmAdapter? = null
    val filmsViewModel: FilmsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_films, container, false)

        initRecyclerFilms()

        loadFilms()

        return binding?.root


    }

    private fun initRecyclerFilms(){
        binding?.recyclerFilms?.layoutManager = LinearLayoutManager(context)
        filmAdapter = FilmAdapter()
        binding?.recyclerFilms?.adapter = filmAdapter

    }

    private fun loadFilms(){
        filmsViewModel.loadFilms.observe(viewLifecycleOwner, Observer {
            filmAdapter?.setList(it)
            filmAdapter?.notifyDataSetChanged()
        })
    }
}