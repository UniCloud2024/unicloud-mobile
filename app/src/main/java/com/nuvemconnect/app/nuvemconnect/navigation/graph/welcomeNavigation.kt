package com.nuvemconnect.app.nuvemconnect.navigation.graph

import androidx.core.util.LogWriter
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginScreen
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginViewModel
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.WelcomeScreen

fun NavGraphBuilder.welcomeScreen(){
    composable(route = Screens.Welcome.route) {
        WelcomeScreen(navController = rememberNavController())
    }

    composable(route = Screens.Login.route){
        LoginScreen(navController = rememberNavController(), viewModel = LoginViewModel())
    }

}