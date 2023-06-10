package com.feature.movie.data.repository

import com.core.network.data_provider.MovieDataProvider
import com.feature.movie.data.mapper.toDomainModel
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieDataProvider: MovieDataProvider) :
    IMovieRepository {
    override suspend fun getMovieList(apiKey: String, query: String): List<Movie> {
        return movieDataProvider.getMovieList(apiKey, query).toDomainModel()
    }
}