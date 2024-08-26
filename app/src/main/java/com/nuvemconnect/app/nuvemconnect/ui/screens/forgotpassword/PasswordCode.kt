package com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.TopBar
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary

@Composable
fun PasswordCode(modifier: Modifier = Modifier, navController: NavController) {

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(top = 36.dp, start = 16.dp, end = 16.dp)
    ) {
        TopBar(
            headingTitle = stringResource(id = R.string.title_forgot_password_2),
            subtitleText = stringResource(id = R.string.subtitle_forgot_password_2),
            navController = navController,
            onBackClick = { navController.navigateUp() }
        )
        Spacer(modifier = modifier.height(45.dp))
        Row {
            Text(text = "codigo aqui")
        }
        Spacer(modifier = modifier.height(26.dp))
        CustomButton(
            onClick = {
                navController.navigate(Screens.ResetPassword.route)
            },
            text = stringResource(R.string.verificar),
            backgroundColor = primary,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(21.dp))

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PasswordCodePreview() {
    PasswordCode(navController = rememberNavController())
}