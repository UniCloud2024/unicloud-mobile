package com.nuvemconnect.app.nuvemconnect.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginScreen
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.WelcomeScreen
import com.nuvemconnect.app.nuvemconnect.ui.screens.splash.SplashScreen

fun NavGraphBuilder.splashScreen(
    navigateToLogin: () -> Unit
){
    composable(route = Screens.Splash.route) {
        SplashScreen(navigateToLogin = navigateToLogin)
    }
    composable(route = Screens.Welcome.route) {
        WelcomeScreen(navController = rememberNavController())
    }

}