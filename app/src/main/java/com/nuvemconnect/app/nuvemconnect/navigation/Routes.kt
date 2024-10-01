package com.nuvemconnect.app.nuvemconnect.navigation

sealed class Screens(
    val route: String,
) {
    data object Login : Screens("login")

    data object Register : Screens("register")

    data object ForgotPassword : Screens("forgot_password")

    data object VerificationCode : Screens("verification_code")

    data object ResetPassword : Screens("reset_password")

    data object Home : Screens("home")

    data object Splash : Screens("splash")

    data object Welcome : Screens("welcome")

    data object VerificationLink : Screens("verification_link")
}

sealed class Graph(
    val route: String,
) {
    data object HomeGraph : Graph("home_graph")

    data object AuthGraph : Graph(route = "auth_graph")
}
