package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Graph.AuthGraph
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.splash.SplashScreen

fun NavGraphBuilder.splashScreen(
    navController: NavController,
    modifier: Modifier,
) {
    composable(route = Screens.Splash.route) {
        SplashScreen(modifier = modifier, navigateToWelcome = { navController.navigate(route = AuthGraph.route) })
    }
}
