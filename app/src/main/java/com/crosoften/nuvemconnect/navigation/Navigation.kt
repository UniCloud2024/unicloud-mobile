package com.crosoften.nuvemconnect.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.crosoften.nuvemconnect.navigation.graph.loginScreen
import com.crosoften.nuvemconnect.navigation.graph.splashScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        splashScreen{
            navController.navigate(Screens.SignIn.route){
                popUpTo(Screens.Splash.route){
                    inclusive = true
                }
            }
        }

        loginScreen()
    }
}