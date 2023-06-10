package com.feature.movie_details.data.di

import com.core.network.data_provider.MovieDataProvider
import com.feature.movie_details.data.repository.MovieDetailsRepositoryImpl
import com.feature.movie_details.domain.repository.IMovieDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {


    @Provides
    fun provideMovieDetailsRepository(movieDataProvider: MovieDataProvider): IMovieDetailsRepository {
        return MovieDetailsRepositoryImpl(movieDataProvider)
    }
}