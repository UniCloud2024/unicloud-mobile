package com.nuvemconnect.app.nuvemconnect.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginScreen

fun NavGraphBuilder.loginScreen(){
    composable(route = Screens.SignIn.route) {
        LoginScreen()
    }
}