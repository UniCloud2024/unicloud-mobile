package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword.ResetPasswordScreen
import org.koin.androidx.compose.getViewModel

fun NavGraphBuilder.resetPasswordScreen(navController: NavController) {
    composable(route = "{Screens.ResetPassword.route}/{tokenUUID}/{token}/{email}") { backStackEntry ->
        val tokenUUID = backStackEntry.arguments?.getString("tokenUUID") ?: return@composable
        val token = backStackEntry.arguments?.getString("token") ?: return@composable
        val email = backStackEntry.arguments?.getString("email") ?: return@composable

        val viewModel: ResetPasswordViewModel = getViewModel()
        viewModel.updateArguments(tokenUUID = tokenUUID, token = token, email = email)

        Log.e("ResetPasswordNavigation", "tokenUUID: $tokenUUID, token: $token  email: $email,")
        ResetPasswordScreen(navController = navController, viewModel)
    }
}

fun NavController.navigateToResetPassword(
    tokenUUID: String,
    token: String,
    email: String,
) {
    navigate(route = "{Screens.ResetPassword.route}/$tokenUUID/$token/$email") {
        launchSingleTop = true
        popUpTo(Screens.ResetPassword.route)
    }
}
