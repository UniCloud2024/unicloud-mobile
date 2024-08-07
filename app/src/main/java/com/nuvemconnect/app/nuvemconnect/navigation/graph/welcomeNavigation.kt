package com.nuvemconnect.app.nuvemconnect.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginScreen
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.WelcomeScreen

fun NavGraphBuilder.welcomeScreen(){
    composable(route = Screens.Welcome.route) {
        WelcomeScreen()
    }

    composable(route = Screens.Login.route){
        LoginScreen()
    }

}