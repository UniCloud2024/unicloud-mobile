package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.WelcomeScreen

fun NavGraphBuilder.welcomeScreen(navController: NavController)  {
    composable(route = Screens.Welcome.route) {
        WelcomeScreen(navController = navController)
    }
}

fun NavController.navigateToWelcome()  {
    navigate(route = Screens.Welcome.route) {
        launchSingleTop = true
        popUpTo(Screens.Welcome.route) {
            inclusive = true
        }
    }
}
