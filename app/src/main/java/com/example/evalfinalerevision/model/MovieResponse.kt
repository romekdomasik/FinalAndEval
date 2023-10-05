package com.example.evalfinalerevision.model

data class MovieResponse (
    val results: List<MovieResult>
)

data class MovieResult (
    val id: Long,
    val overview: String?,
    val poster_path: String?,
    var title: String?,
    val vote_average: Double,
    val release_date: String?,
    val voteCount: Long?
)
