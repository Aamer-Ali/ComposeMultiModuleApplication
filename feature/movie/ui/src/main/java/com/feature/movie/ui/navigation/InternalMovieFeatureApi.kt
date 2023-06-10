@file:OptIn(ExperimentalMaterial3Api::class)

package com.feature.movie.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constatnts.MovieFeature
import com.core.feature_api.IFeatureApi
import com.feature.movie.ui.screen.MovieScreen
import com.feature.movie.ui.screen.MovieSearchViewModel

internal object InternalMovieFeatureApi : IFeatureApi {
    override fun registerGraph(
        navController: NavController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            startDestination = MovieFeature.movie_screen_route,
            route = MovieFeature.nestedRoute
        ) {
            composable(MovieFeature.movie_screen_route) {
                val viewModel = hiltViewModel<MovieSearchViewModel>()
                MovieScreen(viewModel = viewModel,navController)
            }
        }
    }
}