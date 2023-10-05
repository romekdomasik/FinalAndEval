package com.example.evalfinalerevision.model

data class MovieResponse (
    val results: List<MovieResult>
)

data class MovieResult (
    val id: Long,
    val overview: String?,
    val posterPath: String? = null,
    var title: String?,
    val voteAverage: Double?,
    val release_date: String?,
    val voteCount: Long?
)
