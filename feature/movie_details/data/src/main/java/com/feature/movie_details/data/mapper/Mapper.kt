package com.feature.movie_details.data.mapper

import com.core.network.model.movie_details.MovieDetailsDTO
import com.feature.movie_details.domain.model.MovieDetails

fun MovieDetailsDTO.toDomainModel(): MovieDetails {
    return MovieDetails(this.title, this.overview, makeCompleteImageUrl(this.poster_path))
}

fun makeCompleteImageUrl(path: String) = "https://image.tmdb.org/t/p/w500$path"
