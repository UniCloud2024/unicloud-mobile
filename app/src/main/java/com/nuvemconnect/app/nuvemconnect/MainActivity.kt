package com.nuvemconnect.app.nuvemconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nuvemconnect.app.nuvemconnect.navigation.Navigation
import com.nuvemconnect.app.nuvemconnect.ui.theme.NuvemConnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NuvemConnectTheme {
                Navigation()
            }
        }
    }
}
