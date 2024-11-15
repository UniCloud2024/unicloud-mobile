package com.nuvemconnect.app.nuvemconnect.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.navigateToAuthGraph
import com.nuvemconnect.app.nuvemconnect.ui.theme.NuvemConnectTheme
import com.nuvemconnect.app.nuvemconnect.R

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel,
) {
    val modifier: Modifier = Modifier
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (!uiState.value.inOnSearch) {
            Text(text = "Tela da Home")

            Button(onClick = {
                viewModel.logout()
                viewModel.verifyAuthentication()
                if (!uiState.value.isAuthenticated) {
                    navController.navigateToAuthGraph()
                }
            }) {
                Text(text = "Logout", modifier = Modifier.padding(horizontal = 5.dp))
                Icon(painter = painterResource(id = R.drawable.logout), contentDescription = "Logout")
            }
        } else {
            Icon(imageVector = Icons.Rounded.Clear, contentDescription = "Clean page", modifier = Modifier.size(200.dp))
            Text("Não encontramos nada com os termos pesquisados", modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 40.dp))
            TextButton(onClick = {
                viewModel.isOnSearchChange()
                viewModel.resetQuery()
            }) {
                Text("Retornar")
            }
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
