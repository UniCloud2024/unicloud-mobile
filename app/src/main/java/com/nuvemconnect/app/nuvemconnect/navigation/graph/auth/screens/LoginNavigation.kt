package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginScreen
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginViewModel

fun NavGraphBuilder.loginScreen(
    navController: NavController,
    modifier: Modifier,
) {
    composable(route = Screens.Login.route) {
        LoginScreen(navController, LoginViewModel())
    }
}

fun NavController.navigateToLogin() {
    navigate(route = Screens.Login.route) {
        launchSingleTop = true
        popUpTo(Screens.Login.route)
    }
}
