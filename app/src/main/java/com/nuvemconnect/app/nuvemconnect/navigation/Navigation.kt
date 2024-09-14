package com.nuvemconnect.app.nuvemconnect.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.authGraph
import com.nuvemconnect.app.nuvemconnect.navigation.graph.home.homeGraph
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.splashScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route, // SplashGraph
    ) {
        // Splash screen
        splashScreen(navController, modifier)

        // Grafos de Navegação
        authGraph(navController, modifier)
        homeGraph(navController)
    }
}

fun NavController.navigateBack() {
    navigateUp()
}
