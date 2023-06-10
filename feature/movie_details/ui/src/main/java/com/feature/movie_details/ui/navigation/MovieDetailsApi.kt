package com.feature.movie_details.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.core.feature_api.IFeatureApi

interface IMovieDetailsApi : IFeatureApi {
}

class MovieDetailsApiImpl : IMovieDetailsApi {
    override fun registerGraph(navController: NavController, navGraphBuilder: NavGraphBuilder) {
        InternalMovieDetailsFeatureApi.registerGraph(
            navController = navController,
            navGraphBuilder = navGraphBuilder
        )
    }
}