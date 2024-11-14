package com.nuvemconnect.app.nuvemconnect.navigation.graph.home.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.screens.home.HomeScreen
import com.nuvemconnect.app.nuvemconnect.ui.screens.home.HomeTopBar
import com.nuvemconnect.app.nuvemconnect.ui.screens.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable(route = Screens.Home.route) {
        val viewModel: HomeViewModel = koinViewModel()

        Scaffold(topBar = {
            HomeTopBar(onSearchClick = {
                viewModel.onSearchClick()
            }, viewModel = viewModel)
        }) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                HomeScreen(navController = navController, viewModel = viewModel)
            }
        }
    }
}

fun NavController.navigateToHome() {
    navigate(route = Screens.Home.route) {
        launchSingleTop = true
        popUpTo(route = Screens.Home.route) {
            inclusive = true
        }
    }
}
