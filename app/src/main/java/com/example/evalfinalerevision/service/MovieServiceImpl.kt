package com.example.evalfinalerevision.service

import com.example.evalfinalerevision.model.MovieResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MovieServiceImpl {

    private val baseUrl = "https://api.themoviedb.org/3/"

    fun getRetrofit(): Retrofit {
        val okBuilder = OkHttpClient().newBuilder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            callTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
        }

        return Retrofit.Builder()
            .baseUrl(baseUrl) //url du JSON de l'API (c'est la baseUrl pas le endpoint, pas oublié le "/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okBuilder.build())
            .build()
    }


    suspend fun getMovie(movie: String, apiKey: String): MovieResponse =
        getRetrofit().create(MovieService::class.java).getAllMovies(movie, apiKey)

}