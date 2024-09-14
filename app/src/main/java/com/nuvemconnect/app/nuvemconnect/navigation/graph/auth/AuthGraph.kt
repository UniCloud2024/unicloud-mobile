package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.nuvemconnect.app.nuvemconnect.navigation.Graph
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.forgotPasswordScreen
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.loginScreen
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.registerScreen
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.resetPasswordScreen
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.verificationCodeScreen
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.verificationLinkScreen
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.welcomeScreen

fun NavGraphBuilder.authGraph(
    navController: NavController,
    modifier: Modifier,
) {
    navigation(startDestination = Screens.Welcome.route, route = Graph.AuthGraph.route) {
        welcomeScreen(navController)
        registerScreen(navController)
        loginScreen(navController, modifier)
        forgotPasswordScreen(navController)
        verificationCodeScreen(navController)
        resetPasswordScreen(navController)
        verificationLinkScreen(navController)
    }
}
