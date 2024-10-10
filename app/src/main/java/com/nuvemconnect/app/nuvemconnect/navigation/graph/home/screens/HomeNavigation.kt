package com.nuvemconnect.app.nuvemconnect.navigation.graph.home.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.home.HomeScreen

fun NavGraphBuilder.homeScreen(navController: NavController)  {
    composable(route = Screens.Home.route) {
        HomeScreen(navController = navController)
    }
}

fun NavController.navigateToHome()  {
    navigate(route = Screens.Home.route) {
        launchSingleTop = true
        popUpTo(route = Screens.Home.route){
            inclusive = true
        }
    }
}
