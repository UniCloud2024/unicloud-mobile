package com.nuvemconnect.app.nuvemconnect.ui.screens.login

import android.util.Patterns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.model.error.EmailErrorType
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.GoogleButton
import com.nuvemconnect.app.nuvemconnect.ui.components.PasswordTextField
import com.nuvemconnect.app.nuvemconnect.ui.theme.dmSansFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.mediumGray
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoginViewModel
) {

    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val isUserInteracted by viewModel.isUserInteracted.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(90.dp))
        Text(
            text = stringResource(R.string.title_login_screen),
            fontSize = 28.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = modifier.height(21.dp))
        Text(
            text = stringResource(R.string.subtitle_login_screen),
            fontSize = 16.sp,
            fontFamily = dmSansFamily,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )
        Spacer(modifier = modifier.height(52.dp))
        CustomTextField(
            value = email,
            onValueChange = { newEmail ->
                viewModel.onEmailChange(newEmail)
            },
            titleContainer = stringResource(R.string.email),
            placeholder = stringResource(id = R.string.digite_seu_email),
            validate = { email ->
                validateEmail(email)
            },
            isUserInteracted = isUserInteracted
        )
        Spacer(modifier = modifier.height(17.dp))
        PasswordTextField(
            onValueChange = { newPassword ->
                viewModel.onPasswordChange(newPassword)
            },
            value = password,
            titleContainer = stringResource(R.string.senha),
            placeholder = stringResource(R.string.digite_sua_senha),
        )
        Spacer(modifier = modifier.height(26.dp))
        Text(
            text = stringResource(R.string.esqueceu_sua_senha),
            color = primary,
            modifier = modifier
                .align(Alignment.End)
                .clickable {
                    navController.navigate(Screens.Password.route)
                }
                .padding(top = 10.dp),
            fontSize = 16.sp,
            fontFamily = dmSansFamily,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = modifier.height(26.dp))
        CustomButton(
            onClick = { /*TODO*/ },
            text = "Entrar",
            modifier = modifier.fillMaxWidth(),
            backgroundColor = primary,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = modifier.height(40.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                modifier = modifier.weight(1f)
            )
            Text(
                text = stringResource(R.string.ou_faca_seu_login),
                fontSize = 14.sp,
                fontFamily = dmSansFamily,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
            HorizontalDivider(
                thickness = 1.dp,
                modifier = modifier.weight(1f)
            )
        }
        Spacer(modifier = modifier.height(17.dp))
        GoogleButton(
            onClick = { /*TODO*/ },
            text = "Google",
            backgroundColor = Color.Transparent,
            textColor = Color.Black,
            contentColor = Color.Gray,
            border = BorderStroke(2.dp, mediumGray)
        )
        Spacer(modifier = modifier.height(30.dp))
        Row {
            Text(
                text = stringResource(R.string.nao_tem_uma_conta),
                color = Color.Gray,
                fontSize = 16.sp,
                fontFamily = dmSansFamily,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = stringResource(R.string.inscreva_se),
                color = primary,
                fontSize = 16.sp,
                fontFamily = dmSansFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate(Screens.Register.route)
                }
            )
        }
    }
}

fun validateEmail(email: String): EmailErrorType {
    return when {
        email.isEmpty() -> EmailErrorType.Empty
        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> EmailErrorType.InvalidFormat
        else -> EmailErrorType.None
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(Modifier, rememberNavController(), LoginViewModel())
}
