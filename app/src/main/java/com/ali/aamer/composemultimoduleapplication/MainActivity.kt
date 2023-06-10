package com.ali.aamer.composemultimoduleapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ali.aamer.composemultimoduleapplication.navigation.AppNavGraph
import com.ali.aamer.composemultimoduleapplication.navigation.NavigationProvider
import com.ali.aamer.composemultimoduleapplication.ui.theme.ComposeMultiModuleApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMultiModuleApplicationTheme {
                val navController = rememberNavController()
                App(navController = navController, navigationProvider = navigationProvider)
            }
        }
    }
}

@Composable
fun App(navController: NavHostController, navigationProvider: NavigationProvider) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AppNavGraph(navController = navController, navigationProvider = navigationProvider)
    }
}
