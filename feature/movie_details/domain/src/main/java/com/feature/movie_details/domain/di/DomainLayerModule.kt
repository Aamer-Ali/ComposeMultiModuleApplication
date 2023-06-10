package com.feature.movie_details.domain.di

import com.feature.movie_details.domain.repository.IMovieDetailsRepository
import com.feature.movie_details.domain.use_cases.GetMovieDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideGetMovieDetailsUseCase(movieRepository: IMovieDetailsRepository): GetMovieDetailsUseCase {
        return GetMovieDetailsUseCase(movieRepository)
    }
}