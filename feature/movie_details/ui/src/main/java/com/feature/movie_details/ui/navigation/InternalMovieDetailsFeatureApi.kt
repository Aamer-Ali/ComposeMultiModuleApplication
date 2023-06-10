package com.feature.movie_details.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constatnts.MovieDetailsFeature
import com.core.feature_api.IFeatureApi
import com.feature.movie_details.ui.screen.MovieDetailsScreen
import com.feature.movie_details.ui.screen.MovieDetailsViewModel

internal object InternalMovieDetailsFeatureApi : IFeatureApi {
    override fun registerGraph(navController: NavController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            startDestination = MovieDetailsFeature.movieDetailScreenRoute,
            route = MovieDetailsFeature.nestedRoute
        ) {
            composable(MovieDetailsFeature.movieDetailScreenRoute) {
                val id = it.arguments?.getString("id")
                val viewMode = hiltViewModel<MovieDetailsViewModel>()
                MovieDetailsScreen(id.toString(), viewMode)
            }
        }
    }


}