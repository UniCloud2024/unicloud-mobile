package com.nuvemconnect.app.nuvemconnect.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.nuvemconnect.app.nuvemconnect.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navigateToWelcome: () -> Unit) {
    LaunchedEffect(key1 = Unit) {
        delay(1000)
        navigateToWelcome()
        /* TODO: substituir a 'navegacao fixa' do navigateToWelcome() por logica:
            'when(isUserAuthenticated){
            true -> Graph.HomeGraph.route
            false -> Graph.AuthGraph.route
         */
    }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Icon(
            painter = painterResource(id = R.drawable.nuvem_connect_logo),
            contentDescription = stringResource(
                R.string.logo
            ),
            tint = Color(0xFF0D2844)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen {}
}