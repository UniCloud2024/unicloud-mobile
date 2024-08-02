package com.crosoften.nuvemconnect.navigation

sealed class Screens(val route: String) {
    data object SignIn: Screens("login")
    data object SignUp: Screens("register")
    data object Home: Screens("home")
    data object Splash: Screens("splash")
}

