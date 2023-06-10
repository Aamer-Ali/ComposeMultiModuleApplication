package com.core.network

import com.core.network.model.MovieListResponse
import com.core.network.model.movie_details.MovieDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {
    @GET("3/search/movie")
    suspend fun getMoviesList(
        @Query("api_key") api_key: String,
        @Query("query") query: String
    ): MovieListResponse

    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: String,
        @Query("api_key") api_key: String,
    ): MovieDetailsDTO
}