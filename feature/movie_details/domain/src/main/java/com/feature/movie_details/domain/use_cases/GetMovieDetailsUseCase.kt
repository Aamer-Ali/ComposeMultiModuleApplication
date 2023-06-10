package com.feature.movie_details.domain.use_cases

import com.core.common.UiEvent
import com.feature.movie_details.domain.model.MovieDetails
import com.feature.movie_details.domain.repository.IMovieDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val movieDetailsRepository: IMovieDetailsRepository) {
    operator fun invoke(id: String, apiKey: String) = flow<UiEvent<MovieDetails>> {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(data = movieDetailsRepository.getMovieDetails(id, apiKey)))
    }.catch {
        emit((UiEvent.Error(message = it.message.toString())))
    }.flowOn(Dispatchers.IO)

}