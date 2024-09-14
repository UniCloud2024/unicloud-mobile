package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.register.RegisterScreen

fun NavGraphBuilder.registerScreen(navController: NavController) {
    composable(route = Screens.Register.route) {
        RegisterScreen(navController = navController)
    }
}

fun NavController.navigateToRegister() {
    navigate(route = Screens.Register.route) {
        launchSingleTop = true
        popUpTo(route = Screens.Register.route)
    }
}
