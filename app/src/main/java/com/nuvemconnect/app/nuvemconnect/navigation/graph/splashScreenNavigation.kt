package com.nuvemconnect.app.nuvemconnect.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.splash.SplashScreen

fun NavGraphBuilder.splashScreen(
    navigateToLogin: () -> Unit
){
    composable(route = Screens.Splash.route) {
        SplashScreen(navigateToLogin = navigateToLogin)
    }
}