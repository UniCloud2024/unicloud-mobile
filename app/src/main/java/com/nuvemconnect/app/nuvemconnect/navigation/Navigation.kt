package com.nuvemconnect.app.nuvemconnect.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.authGraph
import com.nuvemconnect.app.nuvemconnect.navigation.graph.home.homeGraph

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Graph.HomeGraph.route,
    ) {
        // Splash screen
        splashScreen(navController, modifier)

        // Grafos de Navegação
        authGraph(navController)
        homeGraph(navController)
    }
}

fun NavController.navigateBack() {
    navigateUp()
}
