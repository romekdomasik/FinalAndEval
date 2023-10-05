package com.example.evalfinalerevision

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evalfinalerevision.databinding.FragmentMovieSearchBinding
import com.example.evalfinalerevision.model.MovieResponse
import com.example.evalfinalerevision.model.MovieResult
import com.example.evalfinalerevision.service.MovieServiceImpl
import com.example.evalfinalerevision.ui.ViewAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieSearchFragment : Fragment() {

    private lateinit var binding: FragmentMovieSearchBinding

    private val movieService by lazy { MovieServiceImpl() }
    private val apiKey = "55530312075972a425f5fa13e21b218f"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieSearchBinding.inflate(inflater, container, false)

        val btnSearch = binding.searchBtn
        btnSearch.setOnClickListener {
            val movieName = binding.searchBar.text.toString()
            getMovies(movieName)
        }

        return binding.root
    }


    private fun getMovies(movie: String){
        //se met sur le thread IO, execute sur le thread secondaire
        CoroutineScope(Dispatchers.IO).launch {
            //tâches en arriere-plan
            val response = movieService.getMovie(movie, apiKey)
            //retourne sur le main thread
            withContext(Dispatchers.Main){
                val movieList = response
                if (movieList != null) {
                    setupRecyclerView(movieList)
                } else {
                    println("movieList est nul ")
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun setupRecyclerView(movieList: MovieResponse){
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
        recyclerView.adapter = ViewAdapter(movieList.results)
    }

}