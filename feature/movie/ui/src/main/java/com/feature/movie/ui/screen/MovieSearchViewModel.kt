package com.feature.movie.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie.domain.use_cases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(private val getMovieListUseCase: GetMovieListUseCase) :
    ViewModel() {

    private val _movieList = mutableStateOf(MovieSearchStateHolder())
    val movieList: State<MovieSearchStateHolder> get() = _movieList


    private val _query: MutableStateFlow<String> = MutableStateFlow(value = "")
    val query: StateFlow<String> get() = _query

    fun setQuery(s: String) {
        _query.value = s
    }

    init {
        viewModelScope.launch {
            _query.debounce(timeoutMillis = 1000).collectLatest {
                getMoviesList(apiKey = "", query = it)
            }
        }
    }

    private fun getMoviesList(apiKey: String, query: String) =
        viewModelScope.launch(Dispatchers.IO) {
            getMovieListUseCase.invoke(apiKey = apiKey, query = query).onEach { result ->
                when (result) {
                    is UiEvent.Loading -> {
                        _movieList.value = MovieSearchStateHolder(isLoading = true)
                    }

                    is UiEvent.Error -> {
                        _movieList.value = MovieSearchStateHolder(error = result.message.toString())
                    }

                    is UiEvent.Success -> {
                        _movieList.value = MovieSearchStateHolder(data = result.data)
                    }
                }
            }.launchIn(viewModelScope)
        }
}