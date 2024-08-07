package com.nuvemconnect.app.nuvemconnect.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.theme.lightSkyBlue
import com.nuvemconnect.app.nuvemconnect.ui.theme.mediumBlue
import com.nuvemconnect.app.nuvemconnect.ui.theme.secondary

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.logo_name),
            fontWeight = FontWeight.Bold,
            color = colorScheme.secondary,
            fontSize = 40.sp,
            modifier = modifier.padding(top = 100.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.nuvem_connect_logo),
            contentDescription = stringResource(
                id = R.string.logo
            ),
            modifier = modifier.padding(top = 85.9.dp)
        )
        CustomButton(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 120.1.dp),
            onClick = { /*TODO*/ },
            text = "Registre-se",
            backgroundColor = mediumBlue,
            textColor = secondary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        CustomButton(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            onClick = {
                navController.navigate(Screens.Login.route)
            },
            text = "Entrar",
            backgroundColor = lightSkyBlue,
            textColor = secondary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Precisa de ajuda? Entre em contato \n conosco",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W400,
            modifier = modifier.padding(top = 46.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    WelcomeScreen()
}