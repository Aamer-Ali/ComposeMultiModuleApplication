package com.feature.movie.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.core.feature_api.IFeatureApi

interface IMovieApi : IFeatureApi {
}

class MovieApiImpl : IMovieApi {
    override fun registerGraph(navController: NavController, navGraphBuilder: NavGraphBuilder) {
        InternalMovieFeatureApi.registerGraph(navController, navGraphBuilder)
    }
}