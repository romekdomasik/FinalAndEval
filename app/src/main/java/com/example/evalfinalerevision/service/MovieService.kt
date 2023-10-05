package com.example.evalfinalerevision.service

import com.example.evalfinalerevision.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("search/movie")
    suspend fun getAllMovies(
        @Query("query") movie: String,
        @Query("api_key") apiKey: String,
    ) :  MovieResponse


}