package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword.VerificationCodeScreen
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.verificationCodeScreen(navController: NavController) {
    composable(route = "${Screens.VerificationCode.route}/{token}/{uuid}/{email}") { backStackEntry ->
        val token = backStackEntry.arguments?.getString("token") ?: return@composable
        val uuid = backStackEntry.arguments?.getString("uuid") ?: return@composable
        val email = backStackEntry.arguments?.getString("email") ?: return@composable

        val viewModel: VerificationCodeViewModel = koinViewModel()
        LaunchedEffect(Unit) {
            viewModel.updateToken(newToken = token, newUuid = uuid, newEmail = email)
        }

        VerificationCodeScreen(navController = navController, viewModel = viewModel, onNavigateToResetPasword = {
            navController.navigateToResetPassword(tokenUUID = uuid, token = token, email = email)
        })
    }
}

fun NavController.navigateToVerificationCode(
    token: String,
    uuid: String,
    email: String,
) {
    navigate(route = "${Screens.VerificationCode.route}/$token/$uuid/$email") {
        launchSingleTop = true
        popUpTo(route = Screens.VerificationCode.route)
    }
}
