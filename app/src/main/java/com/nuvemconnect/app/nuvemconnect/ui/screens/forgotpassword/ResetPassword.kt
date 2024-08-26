package com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.PasswordTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.TopBar
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary

@Composable
fun ResetPassword(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(top = 36.dp, start = 16.dp, end = 16.dp)
    ) {
        TopBar(
            headingSize = 28.sp,
            headingTitle = stringResource(R.string.title_forgot_password_3),
            subtitleText = stringResource(
                id = R.string.subtitle_forgot_password_3
            ),
            navController = navController,
            onBackClick = { navController.navigateUp() }
        )
        Spacer(modifier = modifier.height(45.dp))
        PasswordTextField(
            onValueChange = {},
            value = "",
            titleContainer = stringResource(R.string.nova_senha),
            placeholder = stringResource(R.string.digite_sua_senha)
        )
        Spacer(modifier = modifier.height(5.dp))
        PasswordTextField(
            onValueChange = {},
            value = "",
            titleContainer = stringResource(R.string.confirme_sua_senha),
            placeholder = stringResource(id = R.string.digite_sua_senha)
        )
        Spacer(modifier = modifier.height(26.dp))
        CustomButton(

            onClick = {
                navController.navigate(Screens.Login.route)
            },
            text = stringResource(R.string.resetar_senha),
            backgroundColor = primary
        )
        Spacer(modifier = Modifier.height(21.dp))
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ResetPasswordPreview() {
    ResetPassword(navController = rememberNavController())
}