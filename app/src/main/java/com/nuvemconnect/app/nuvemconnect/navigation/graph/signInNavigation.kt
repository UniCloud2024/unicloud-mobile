package com.nuvemconnect.app.nuvemconnect.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginScreen

fun NavGraphBuilder.singInScreen(navigate: Unit) {
    composable(route = Screens.Login.route) {
        LoginScreen()
    }
}