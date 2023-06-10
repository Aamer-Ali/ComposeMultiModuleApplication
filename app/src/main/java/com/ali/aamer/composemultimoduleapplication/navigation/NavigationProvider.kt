package com.ali.aamer.composemultimoduleapplication.navigation

import com.feature.movie.ui.navigation.IMovieApi
import com.feature.movie_details.ui.navigation.IMovieDetailsApi

data class NavigationProvider(val iMovieApi: IMovieApi, val movieDetailsApi: IMovieDetailsApi)
