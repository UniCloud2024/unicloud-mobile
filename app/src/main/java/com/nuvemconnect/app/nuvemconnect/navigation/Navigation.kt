package com.nuvemconnect.app.nuvemconnect.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.model.error.PasswordErrorType
import com.nuvemconnect.app.nuvemconnect.navigation.graph.splashScreen
import com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword.ForgotPassword
import com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword.PasswordCode
import com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword.ResetPassword
import com.nuvemconnect.app.nuvemconnect.ui.screens.home.HomeScreen
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginScreen
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginViewModel
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.WelcomeScreen
import com.nuvemconnect.app.nuvemconnect.ui.screens.register.RegisterScreen
import com.nuvemconnect.app.nuvemconnect.ui.screens.register.VerificationLinkScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        splashScreen {
            navController.navigate(Screens.Welcome.route) {
                popUpTo(Screens.Splash.route) {
                    inclusive = true
                }
            }
        }
        composable(route = Screens.Welcome.route) {
            WelcomeScreen(navController = navController)
        }

        composable(route = Screens.Register.route) {
            RegisterScreen(navController = navController)
        }

        composable(route = Screens.Login.route) {
            LoginScreen(modifier, navController, LoginViewModel())
        }

        composable(route = Screens.Password.route) {
            ForgotPassword(modifier, navController)
        }
        composable(route = Screens.ForgotPassword.route) {
            ForgotPassword(navController = navController)
        }
        composable(route = Screens.PasswordCode.route) {
            PasswordCode(navController = navController)
        }
        composable(route = Screens.ResetPassword.route) {
            ResetPassword(navController = navController)
        }
        composable(route = Screens.VerificationLink.route) {
            VerificationLinkScreen(navController = navController)
        }
        composable(route = Screens.Home.route){
            HomeScreen(navController = navController)
        }
    }
}