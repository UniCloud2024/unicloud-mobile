package com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.navigateToResetPassword
import com.nuvemconnect.app.nuvemconnect.ui.components.CodeNumberField
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.TopBar
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary100

@Composable
fun VerificationCodeScreen(modifier: Modifier = Modifier, navController: NavController) {

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(top = 36.dp, start = 21.dp, end = 21.dp)
    ) {
        TopBar(
            headingTitle = stringResource(id = R.string.title_forgot_password_2),
            subtitleText = stringResource(id = R.string.subtitle_forgot_password_2),
            navController = navController,
            onBackClick = { navController.navigateUp() }
        )
        Spacer(modifier = modifier.height(45.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CodeNumberField()
        }

        Spacer(modifier = modifier.height(34.dp))
        CustomButton(
            onClick = {
                navController.navigateToResetPassword()
            },
            text = stringResource(R.string.verificar),
            backgroundColor = primary100,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(21.dp))

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun VerificationCodePreview() {
    VerificationCodeScreen(navController = rememberNavController())
}