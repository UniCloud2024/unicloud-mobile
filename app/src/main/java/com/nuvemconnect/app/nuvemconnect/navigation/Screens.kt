package com.nuvemconnect.app.nuvemconnect.navigation

sealed class Screens(val route: String) {
    data object Login : Screens("login")
    data object Register : Screens("register")
    data object Password : Screens("password")
    data object ForgotPassword : Screens("forgot_password")
    data object PasswordCode : Screens("password_code")
    data object ResetPassword : Screens("reset_password")
    data object Home : Screens("home")
    data object Splash : Screens("splash")
    data object Welcome : Screens("welcome")

}

