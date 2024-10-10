package com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.model.service.ResetPasswordResponse
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.TopBar
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.validateEmail
import com.nuvemconnect.app.nuvemconnect.ui.theme.dmSansFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary100
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun ForgotPasswordScreen(
    navController: NavController,
    onElevateEmail: (String) -> Unit = {},
    viewModel: ForgotPasswordViewModel = koinViewModel(),
    onNavigateToVerificationCode: (ResetPasswordResponse) -> Unit = {},
) {
    val modifier: Modifier = Modifier
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val uiStateWithRemember = remember { viewModel.uiState }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(top = 36.dp, start = 21.dp, end = 21.dp),
    ) {
        TopBar(
            headingSize = 28.sp,
            headingTitle = stringResource(R.string.title_forgot_password_1),
            subtitleText = stringResource(id = R.string.subtitle_forgot_password_1),
            subtitleSize = 18.sp,
            navController = navController,
            onBackClick = { navController.navigateUp() },
        )

        Column(modifier.verticalScroll(scrollState)) {
            Spacer(modifier = modifier.height(45.dp))
            CustomTextField(
                value = uiState.value.email,
                onValueChange = { newEmail ->
                    viewModel.onEmailChange(newEmail)
                    validateEmail(uiState.value.email)
                },
                placeholder = stringResource(R.string.digite_seu_email),
                leadingIcon = painterResource(id = R.drawable.baseline_mail_outline_24),
                validate = { email ->
                    validateEmail(email)
                },
                isUserInteracted = uiState.value.isUserInteracted,
            )
            Spacer(modifier = modifier.height(26.dp))
            CustomButton(
                onClick = {
                    viewModel.resetPasswordRequest()
                    scope.launch {
                        delay(1000)
                        uiStateWithRemember.collect { state ->
                            if (state.onSucess)
                                {
                                    uiState.value.response?.let {
                                        onElevateEmail(state.email)
                                        onNavigateToVerificationCode(it)
                                    }
                                }

                            if (state.onError != null)
                                {
                                    uiState.value.onError?.let {
                                        Toast.makeText(context, state.onError, Toast.LENGTH_LONG).show()
                                    }
                                    delay(1000)
                                    viewModel.dimissError()
                                }
                        }
                    }
                },
                text = stringResource(R.string.enviar_codigo),
                backgroundColor = primary100,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(21.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxWidth(),
            ) {
                Text(
                    text = stringResource(R.string.voltar_para),
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontFamily = dmSansFamily,
                    fontWeight = FontWeight.Normal,
                )
                Text(
                    text = stringResource(R.string.fazer_login),
                    color = primary100,
                    fontSize = 16.sp,
                    fontFamily = dmSansFamily,
                    fontWeight = FontWeight.Normal,
                    modifier =
                        modifier.clickable {
                            navController.navigate(Screens.Login.route)
                        },
                )
            }
            Spacer(modifier = modifier.padding(bottom = 16.dp))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ForgotPasswordPreview() {
    ForgotPasswordScreen(rememberNavController(), viewModel = ForgotPasswordViewModel())
}
