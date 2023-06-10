package com.feature.movie.domain.repository

import com.feature.movie.domain.model.Movie

interface IMovieRepository {
    suspend fun getMovieList(apiKey: String, query: String): List<Movie>
}