package com.nuvemconnect.app.nuvemconnect.ui.screens.login

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.nuvemconnect.app.nuvemconnect.model.error.EmailErrorType
import com.nuvemconnect.app.nuvemconnect.model.error.PasswordErrorType
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.navigateToForgotPasswordScreen
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.GoogleButton
import com.nuvemconnect.app.nuvemconnect.ui.components.PasswordTextField
import com.nuvemconnect.app.nuvemconnect.ui.theme.dmSansFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.mediumGray
import com.nuvemconnect.app.nuvemconnect.ui.theme.neutral100
import com.nuvemconnect.app.nuvemconnect.ui.theme.neutral60
import com.nuvemconnect.app.nuvemconnect.ui.theme.neutral70
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary100
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = koinViewModel(),
    navigateToHome: () -> Unit = {},
) {
    val modifier: Modifier = Modifier
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val uiStateWithRemember: StateFlow<LoginUiState> = remember { viewModel.uiState }

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = modifier.height(90.dp))
        Text(
            text = stringResource(R.string.title_login_screen),
            fontSize = 28.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.ExtraBold,
            color = neutral100,
        )
        Spacer(modifier = modifier.height(21.dp))
        Text(
            text = stringResource(R.string.subtitle_login_screen),
            fontSize = 16.sp,
            fontFamily = dmSansFamily,
            fontWeight = FontWeight.Normal,
            color = neutral70,
        )
        Spacer(modifier = modifier.height(52.dp))
        CustomTextField(
            value = uiState.value.email,
            onValueChange = { newEmail ->
                viewModel.onEmailChange(newEmail)
            },
            leadingIcon = painterResource(id = R.drawable.baseline_mail_outline_24),
            placeholder = stringResource(id = R.string.email),
            validate = { email ->
                validateEmail(email)
            },
            isUserInteracted = uiState.value.isUserInteracted,
        )
        Spacer(modifier = modifier.height(17.dp))
        PasswordTextField(
            onValueChange = { newPassword ->
                viewModel.onPasswordChange(newPassword)
            },
            value = uiState.value.password,
            placeholder = stringResource(R.string.senha),
            validate = { password ->
                validatePassword(password)
            },
            isUserInteracted = uiState.value.isUserInteracted,
        )
        Spacer(modifier = modifier.height(26.dp))
        Text(
            text = stringResource(R.string.esqueceu_sua_senha),
            color = primary100,
            modifier =
                modifier
                    .align(Alignment.End)
                    .clickable {
                        navController.navigateToForgotPasswordScreen()
                    }.padding(top = 10.dp),
            fontSize = 16.sp,
            fontFamily = dmSansFamily,
        )
        Spacer(modifier = modifier.height(66.dp))

        CustomButton(
            onClick = {
                val validateEmail = validateEmail(uiState.value.email)
                val validatePassword = validatePassword(uiState.value.password)
                if (validateEmail == EmailErrorType.None && validatePassword == PasswordErrorType.None) {
                    viewModel.onLoginClick()

                    scope.launch {
                        uiStateWithRemember.collect { state ->
                            if (state.onSucess) {
                                delay(1000)
                                navigateToHome()
                            }

                            state.onError?.let {
                                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    scope.launch {
                        delay(3000)
                        viewModel.dimissError()
                    }
                }
            },
            text = "Entrar",
            modifier = modifier.fillMaxWidth(),
            backgroundColor = primary100,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth(),
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                modifier = modifier.weight(1f),
            )
            Text(
                text = stringResource(R.string.ou_faca_seu_login),
                fontSize = 14.sp,
                fontFamily = dmSansFamily,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
            )
            HorizontalDivider(
                thickness = 1.dp,
                modifier = modifier.weight(1f),
            )
        }
        Spacer(modifier = modifier.height(16.dp))
        GoogleButton(
            onClick = {
                viewModel.onGoogleLoginCLick()
                scope.launch {
                    uiStateWithRemember.collect { state ->
                        state.onError?.let {
                            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            },
            text = "Entrar com Google",
            backgroundColor = Color.Transparent,
            textColor = Color.Black,
            contentColor = Color.Gray,
            border = BorderStroke(2.dp, mediumGray),
        )
        Spacer(modifier = modifier.height(30.dp))
        Row {
            Text(
                text = stringResource(R.string.nao_tem_uma_conta),
                color = neutral60,
                fontSize = 16.sp,
                fontFamily = dmSansFamily,
                fontWeight = FontWeight.Normal,
            )
            Text(
                text = stringResource(R.string.inscreva_se),
                color = primary100,
                fontSize = 16.sp,
                fontFamily = dmSansFamily,
                fontWeight = FontWeight.Normal,
                modifier =
                    Modifier.clickable {
                        navController.navigate(Screens.Register.route)
                    },
            )
        }

        Spacer(modifier = modifier.height(30.dp))
    }
}

fun validateEmail(email: String): EmailErrorType =
    when {
        email.isEmpty() -> EmailErrorType.Empty
        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> EmailErrorType.InvalidFormat
        else -> EmailErrorType.None
    }

fun validatePassword(password: String): PasswordErrorType =
    when {
        password.isEmpty() -> PasswordErrorType.Empty
        password.length < 8 -> PasswordErrorType.minimumPassword
        else -> PasswordErrorType.None
    }

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(rememberNavController(), LoginViewModel())
}
