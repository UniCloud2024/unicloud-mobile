package com.nuvemconnect.app.nuvemconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.navigation.Navigation
import com.nuvemconnect.app.nuvemconnect.ui.theme.NuvemConnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NuvemConnectTheme {
                Scaffold { paddingValues ->
                    Navigation(navController, modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}
