package com.nuvemconnect.app.nuvemconnect.navigation.graph.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.nuvemconnect.app.nuvemconnect.navigation.Graph
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.navigation.graph.home.screens.homeScreen

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(startDestination = Screens.Home.route, route = Graph.HomeGraph.route) {
        homeScreen(navController)
    }
}

fun NavController.navigateToHomeGraph() {
    navigate(route = Graph.HomeGraph.route) {
        launchSingleTop = true
        popUpTo(route = Graph.AuthGraph.route) {
            inclusive = true
        }
    }
}

fun NavController.navigateToHomeGraphWithClearBackstack() {
    navigate(route = Graph.HomeGraph.route) {
        launchSingleTop = true
        popUpTo(0)
    }
}
