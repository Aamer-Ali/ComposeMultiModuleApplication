package com.feature.movie.ui.di

import com.feature.movie.ui.navigation.IMovieApi

import com.feature.movie.ui.navigation.MovieApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UiLayerModule {

    @Provides
    fun provideMovieApi(): IMovieApi {
        return MovieApiImpl()
    }
}