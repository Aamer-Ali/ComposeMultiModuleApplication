package com.feature.movie_details.ui.di

import com.feature.movie_details.ui.navigation.IMovieDetailsApi
import com.feature.movie_details.ui.navigation.MovieDetailsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object UiLayerModule {

    @Provides
    fun provideMovieDetailApi(): IMovieDetailsApi {
        return MovieDetailsApiImpl()
    }
}