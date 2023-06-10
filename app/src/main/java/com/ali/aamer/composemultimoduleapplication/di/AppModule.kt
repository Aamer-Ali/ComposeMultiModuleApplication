package com.ali.aamer.composemultimoduleapplication.di

import com.ali.aamer.composemultimoduleapplication.navigation.NavigationProvider
import com.feature.movie.ui.navigation.IMovieApi
import com.feature.movie_details.ui.navigation.IMovieDetailsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideNavigationProvider(
        iMovieApi: IMovieApi,
        iMovieDetailsApi: IMovieDetailsApi
    ): NavigationProvider {
        return NavigationProvider(iMovieApi, iMovieDetailsApi)
    }

}