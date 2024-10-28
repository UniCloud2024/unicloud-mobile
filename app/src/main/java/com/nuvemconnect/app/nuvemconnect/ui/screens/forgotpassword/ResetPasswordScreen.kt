package com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.model.error.PasswordErrorType
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.navigateToLoginWithClearBackstack
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.PasswordTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.TopBar
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary100
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ResetPasswordScreen(
    navController: NavController,
    viewModel: ResetPasswordViewModel,
) {
    val modifier: Modifier = Modifier
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val uiStateWithRemember = remember { viewModel.uiState }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(top = 36.dp, start = 16.dp, end = 16.dp),
    ) {
        TopBar(
            headingSize = 28.sp,
            headingTitle = stringResource(R.string.title_forgot_password_3),
            subtitleText =
                stringResource(
                    id = R.string.subtitle_forgot_password_3,
                ),
            navController = navController,
            onBackClick = { navController.navigateUp() },
        )

        Column(modifier.verticalScroll(scrollState)) {
            Spacer(modifier = modifier.height(68.dp))
            PasswordTextField(
                onValueChange = { newPassword ->
                    viewModel.updatePassword(newPassword)
                },
                value = uiState.value.password,
                placeholder = stringResource(R.string.digite_sua_senha),
                validate = { password ->
                    validatePassword(password)
                },
                isUserInteracted = uiState.value.isUserInteracted,
            )
            Spacer(modifier = modifier.height(30.dp))
            PasswordTextField(
                onValueChange = { newPassword ->
                    viewModel.updateConfirmPassword(newPassword)
                },
                value = uiState.value.confirmPassword,
                placeholder = stringResource(id = R.string.confirme_sua_senha),
                validate = {
                    validatePassword(uiState.value.password)
                },
                isUserInteracted = uiState.value.isUserInteracted,
            )
            Spacer(modifier = modifier.height(40.dp))
            CustomButton(
                onClick = {
                    viewModel.sendResetPassword()
                    scope.launch {
                        delay(1000)
                        uiStateWithRemember.collect { state ->
                            if (state.onSucess != null) {
                                Toast.makeText(context, state.onSucess, Toast.LENGTH_LONG).show()
                                navController.navigateToLoginWithClearBackstack()
                                delay(1000)
                                viewModel.dimissSucess()
                            }

                            if (state.onError != null) {
                                Toast.makeText(context, state.onError, Toast.LENGTH_LONG).show()
                                delay(1000)
                                viewModel.dimissError()
                            }
                        }
                    }
                },
                text = stringResource(R.string.redefinir),
                backgroundColor = primary100,
            )
            Spacer(modifier = Modifier.height(21.dp))
            Spacer(modifier = modifier.padding(bottom = 16.dp))
        }
    }
}

fun validatePassword(password: String): PasswordErrorType =
    when {
        password.isEmpty() -> PasswordErrorType.Empty
        password.length < 8 -> PasswordErrorType.rulePassword
        else -> PasswordErrorType.None
    }

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ResetPasswordPreview() {
    ResetPasswordScreen(navController = rememberNavController(), viewModel = ResetPasswordViewModel())
}
