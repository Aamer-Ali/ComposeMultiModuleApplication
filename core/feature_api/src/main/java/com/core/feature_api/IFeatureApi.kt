package com.core.feature_api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface IFeatureApi {
    fun registerGraph(navController: NavController, navGraphBuilder: NavGraphBuilder)
}