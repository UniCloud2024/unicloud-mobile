package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword.ResetPasswordScreen

fun NavGraphBuilder.resetPasswordScreen(navController: NavController)  {
    composable(route = Screens.ResetPassword.route) {
        ResetPasswordScreen(navController = navController)
    }
}

fun NavController.navigateToResetPassword()  {
    navigate(route = Screens.ResetPassword.route) {
        launchSingleTop = true
        popUpTo(Screens.ResetPassword.route)
    }
}
