package com.feature.movie.data.di

import com.core.network.data_provider.MovieDataProvider
import com.feature.movie.data.repository.MovieRepositoryImpl
import com.feature.movie.domain.repository.IMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun provideMovieRepository(movieDataProvider: MovieDataProvider): IMovieRepository {
        return MovieRepositoryImpl(movieDataProvider)
    }
}