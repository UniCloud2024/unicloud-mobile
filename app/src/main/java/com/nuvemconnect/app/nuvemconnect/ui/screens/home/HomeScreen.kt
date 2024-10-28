package com.nuvemconnect.app.nuvemconnect.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.navigateToAuthGraph
import com.nuvemconnect.app.nuvemconnect.ui.theme.NuvemConnectTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val modifier: Modifier = Modifier
    val scope = rememberCoroutineScope()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val uiStateWithRemember = remember { viewModel.uiState }

    LaunchedEffect(Unit) {
        scope.launch {
            uiStateWithRemember.collect { state ->
                if (!state.isAuthenticated) {
                    navController.navigateToAuthGraph()
                }
            }
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Tela da Home")

        Button(onClick = {
            viewModel.logout()
            viewModel.verifyAuthentication()
            if (!uiState.value.isAuthenticated) {
                navController.navigateToAuthGraph()
            }
        }) {
            Text(text = "Logout")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    NuvemConnectTheme {
        HomeScreen(navController = rememberNavController(), HomeViewModel())
    }
}
