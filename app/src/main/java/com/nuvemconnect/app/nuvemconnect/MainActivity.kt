package com.nuvemconnect.app.nuvemconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.navigation.Navigation
import com.nuvemconnect.app.nuvemconnect.ui.theme.NuvemConnectTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var splashTime = MutableStateFlow(true)
        lifecycleScope.launch {
            delay(500)
            splashTime = MutableStateFlow(false)
        }
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                splashTime.value
            }
        }
        setContent {
            val navController = rememberNavController()
            NuvemConnectTheme {
                Scaffold { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues))
                    Navigation(navController)
                }
            }
        }
    }
}
