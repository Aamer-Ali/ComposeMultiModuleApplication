package com.feature.movie.domain.use_cases

import com.core.common.UiEvent
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repository.IMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(private val movieRepository: IMovieRepository) {
    operator fun invoke(apiKey: String, query: String) = flow<UiEvent<List<Movie>>> {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(movieRepository.getMovieList(apiKey = apiKey, query = query)))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}