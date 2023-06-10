package com.feature.movie_details.domain.repository

import com.feature.movie_details.domain.model.MovieDetails

interface IMovieDetailsRepository {
    suspend fun getMovieDetails(id: String, apiKey: String): MovieDetails
}