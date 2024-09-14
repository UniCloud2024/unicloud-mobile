package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.register.VerificationLinkScreen

fun NavGraphBuilder.verificationLinkScreen(navController: NavController)  {
    composable(route = Screens.VerificationLink.route) {
        VerificationLinkScreen(navController = navController)
    }
}

fun NavController.navigateToVerificationLink()  {
    navigate(route = Screens.VerificationLink.route) {
        launchSingleTop = true
        popUpTo(route = Screens.VerificationLink.route)
    }
}
