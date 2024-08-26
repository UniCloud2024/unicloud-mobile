package com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.model.error.EmailErrorType
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.TopBar
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary600


@Composable
fun ForgotPassword(modifier: Modifier = Modifier, navController: NavController) {
    Column {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier.padding(top = 36.dp, start = 16.dp, end = 16.dp)
        ) {
            TopBar(
                headingSize = 28.sp,
                headingTitle = stringResource(R.string.title_forgot_password_1),
                subtitleText = stringResource(id = R.string.subtitle_forgot_password_1),
                navController = navController,
                onBackClick = { navController.navigateUp() }
            )
            Spacer(modifier = modifier.height(45.dp))
            CustomTextField(
                onValueChange = {},
                value = "",
                titleContainer = stringResource(R.string.adicione_seu_email),
                placeholder = stringResource(R.string.digite_seu_email),
                validate = { EmailErrorType.Empty },
                isUserInteracted = false
            )
            Spacer(modifier = modifier.height(26.dp))
            CustomButton(
                onClick = {
                    navController.navigate(Screens.PasswordCode.route)
                },
                text = stringResource(R.string.enviar_codigo),
                backgroundColor = primary,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(21.dp))
        }
        Row(
            modifier = modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.voltar_para),
                color = Color.Gray,
                fontSize = 16.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = stringResource(R.string.fazer_login),
                color = primary600,
                fontSize = 16.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                modifier = modifier.clickable {
                    navController.navigate(Screens.Login.route)
                }
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ForgotPasswordPreview() {
    ForgotPassword(Modifier, rememberNavController())
}
