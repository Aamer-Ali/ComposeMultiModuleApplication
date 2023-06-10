package com.core.network.data_provider

import com.core.network.IApiService
import javax.inject.Inject

class MovieDataProvider @Inject constructor(private val apiService: IApiService) {
    suspend fun getMovieList(apiKey: String, query: String) =
        apiService.getMoviesList(apiKey, query)

    suspend fun getMovieLDetails(id: String, apiKey: String) =
        apiService.getMovieDetails(api_key = apiKey, id = id)
}