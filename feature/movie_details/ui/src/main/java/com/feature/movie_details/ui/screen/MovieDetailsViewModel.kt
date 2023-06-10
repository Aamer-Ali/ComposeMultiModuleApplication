package com.feature.movie_details.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie_details.domain.use_cases.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: GetMovieDetailsUseCase,
    saveStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _movieDetails = mutableStateOf(MovieDetailsStateHolder())
    val movieDetails: State<MovieDetailsStateHolder> get() = _movieDetails

    init {
        saveStateHandle.getLiveData<String>("id").observeForever {
            it?.let {
                getMovieDetails(apiKey = "", id = it)
            }
        }
    }

    private fun getMovieDetails(apiKey: String, id: String) =
        viewModelScope.launch(Dispatchers.IO) {
            movieDetailsUseCase.invoke(apiKey = apiKey, id = id).onEach { result ->
                when (result) {
                    is UiEvent.Loading -> {
                        _movieDetails.value = MovieDetailsStateHolder(isLoading = true)
                    }

                    is UiEvent.Error -> {
                        _movieDetails.value =
                            MovieDetailsStateHolder(error = result.message.toString())
                    }

                    is UiEvent.Success -> {
                        _movieDetails.value = MovieDetailsStateHolder(data = result.data)
                    }
                }
            }.launchIn(viewModelScope)
        }

}