package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword.VerificationCodeScreen

fun NavGraphBuilder.verificationCodeScreen(navController: NavController)  {
    composable(route = Screens.VerificationCode.route) {
        VerificationCodeScreen(navController = navController)
    }
}

fun NavController.navigateToVerificationCode()  {
    navigate(route = Screens.VerificationCode.route) {
        launchSingleTop = true
        popUpTo(route = Screens.VerificationCode.route)
    }
}
