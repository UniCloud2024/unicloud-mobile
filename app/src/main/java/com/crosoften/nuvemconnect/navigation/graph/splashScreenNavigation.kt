package com.crosoften.nuvemconnect.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.crosoften.nuvemconnect.navigation.Screens
import com.crosoften.nuvemconnect.ui.screens.splash.SplashScreen

fun NavGraphBuilder.splashScreen(
    navigateToLogin: () -> Unit
){
    composable(route = Screens.Splash.route) {
        SplashScreen(navigateToLogin = navigateToLogin)
    }
}