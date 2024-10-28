package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword.ForgotPasswordScreen

fun NavGraphBuilder.forgotPasswordScreen(navController: NavController) {
    composable(route = Screens.ForgotPassword.route) {
        var receivedEmail: String = ""
        ForgotPasswordScreen(navController = navController, onElevateEmail = { email ->
            receivedEmail = email
        }, onNavigateToVerificationCode = { response ->
            navController.navigateToVerificationCode(token = response.token, uuid = response.tokenUUID, email = receivedEmail)
        })
    }
}

fun NavController.navigateToForgotPasswordScreen() {
    navigate(route = Screens.ForgotPassword.route) {
        launchSingleTop = true
        popUpTo(Screens.ForgotPassword.route)
    }
}
