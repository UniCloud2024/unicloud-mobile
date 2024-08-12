package com.nuvemconnect.app.nuvemconnect.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginScreen

fun NavGraphBuilder.loginScreen(navigate: Unit) {
    composable(route = Screens.Login.route) {
        LoginScreen(navController = rememberNavController())
    }
}