package com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.model.error.PasswordErrorType
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.navigateToLogin
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.PasswordTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.TopBar
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginViewModel
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary100

@Composable
fun ResetPasswordScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),

) {
    val password by viewModel.password.collectAsStateWithLifecycle()
    val confirmedPassword by viewModel.confirmPassword.collectAsStateWithLifecycle()
   val isUserInteracted by viewModel.isUserInteracted.collectAsStateWithLifecycle()


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
        Spacer(modifier = modifier.height(68.dp))
        PasswordTextField(
            onValueChange = { newPassword ->
                viewModel.onPasswordChange(newPassword  )

            },
            value = password,
            placeholder = stringResource(R.string.digite_sua_senha),
            validate = { password ->
                validatePassword(password)
            },
            isUserInteracted = isUserInteracted,
        )
        Spacer(modifier = modifier.height(30.dp))
        PasswordTextField(
            onValueChange = { newPassword ->
                viewModel.onConfirmPassword(newPassword)
            },
            value = confirmedPassword,
            placeholder = stringResource(id = R.string.confirme_sua_senha),
            validate = {
                validatePassword(password)
            },
            isUserInteracted = isUserInteracted
        )
        Spacer(modifier = modifier.height(40.dp))
        CustomButton(
            onClick = {
                navController.navigateToLogin()
            },
            text = stringResource(R.string.redefinir),
            backgroundColor = primary100
        )
        Spacer(modifier = Modifier.height(21.dp))
    }
}
fun validatePassword(password: String): PasswordErrorType {
    return when {
        password.isEmpty() -> PasswordErrorType.Empty
        password.length < 8 -> PasswordErrorType.rulePassword
        else -> PasswordErrorType.None
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ResetPasswordPreview() {
    ResetPasswordScreen(navController = rememberNavController(),)
}