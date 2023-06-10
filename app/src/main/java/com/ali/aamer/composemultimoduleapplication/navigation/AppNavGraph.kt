package com.ali.aamer.composemultimoduleapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.core.common.navigation_constatnts.MovieFeature

@Composable
fun AppNavGraph(navController: NavHostController, navigationProvider: NavigationProvider) {
    NavHost(navController = navController, startDestination = MovieFeature.nestedRoute) {
        navigationProvider.iMovieApi.registerGraph(navController, this)
        navigationProvider.movieDetailsApi.registerGraph(navController, this)
    }
}