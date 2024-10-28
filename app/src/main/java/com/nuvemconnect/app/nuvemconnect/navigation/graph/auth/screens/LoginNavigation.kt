package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.navigation.graph.home.navigateToHomeGraph
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginScreen

fun NavGraphBuilder.loginScreen(navController: NavController) {
    composable(route = Screens.Login.route) {
        LoginScreen(navController, navigateToHome = { navController.navigateToHomeGraph() })
    }
}

fun NavController.navigateToLogin() {
    navigate(route = Screens.Login.route) {
        launchSingleTop = true
        popUpTo(Screens.Login.route) {
            inclusive = true
        }
    }
}

fun NavController.navigateToLoginWithClearBackstack() {
    navigate(route = Screens.Login.route) {
        launchSingleTop = true
        popUpTo(0)
    }
}
