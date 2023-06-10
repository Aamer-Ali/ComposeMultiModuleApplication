package com.feature.movie_details.data.repository

import com.core.network.data_provider.MovieDataProvider
import com.feature.movie_details.data.mapper.toDomainModel
import com.feature.movie_details.domain.model.MovieDetails
import com.feature.movie_details.domain.repository.IMovieDetailsRepository
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(private val movieDataProvider: MovieDataProvider) :
    IMovieDetailsRepository {
    override suspend fun getMovieDetails(id: String, apiKey: String): MovieDetails {
        return movieDataProvider.getMovieLDetails(id, apiKey).toDomainModel()
    }
}