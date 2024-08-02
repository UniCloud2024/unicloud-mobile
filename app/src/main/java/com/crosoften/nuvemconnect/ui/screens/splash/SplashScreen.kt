package com.crosoften.nuvemconnect.ui.screens.splash

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
import com.crosoften.nuvemconnect.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navigateToLogin: () -> Unit) {
    LaunchedEffect(key1 = Unit) {
        delay(1000)
        navigateToLogin()
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Icon(
            painter = painterResource(id = R.drawable.nuvem_connect_logo),
            contentDescription = stringResource(
                R.string.logo
            ),
            tint = Color(0xFF0D2844)
        )
    }
}