package com.nuvemconnect.app.nuvemconnect.ui.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.model.error.NameErrorType
import com.nuvemconnect.app.nuvemconnect.navigation.navigateBack
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.navigateToVerificationLink
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.PasswordTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.TopBar
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginViewModel
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.validateEmail
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.validatePassword
import com.nuvemconnect.app.nuvemconnect.ui.theme.dmSansFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary100

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoginViewModel = viewModel(),
) {

    val name by viewModel.name.collectAsStateWithLifecycle()
    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val confirmPassword by viewModel.confirmPassword.collectAsStateWithLifecycle()
    val isUserInteracted by viewModel.isUserInteracted.collectAsStateWithLifecycle()



    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(top = 36.dp, start = 16.dp, end = 16.dp)
    ) {
        TopBar(
            headingTitle = stringResource(R.string.registre_se),
            subtitleText = stringResource(R.string.insira_suas_informacoes_pessoais),
            navController = navController,
            onBackClick = { navController.navigateBack() }
        )
        Spacer(modifier = modifier.height(29.dp))
        CustomTextField(
            onValueChange = { newEmail ->
                viewModel.onEmailChange(newEmail)
            },
            value = email,
            leadingIcon = painterResource(id = R.drawable.baseline_mail_outline_24),
            placeholder = stringResource(id = R.string.email),
            validate = {
                validateEmail(email)
            },
            isUserInteracted = isUserInteracted
        )
        Spacer(modifier = modifier.height(17.dp))
        CustomTextField(
            onValueChange = { newName ->
                viewModel.onName(newName)
            },
            leadingIcon = painterResource(id = R.drawable.baseline_user_01),
            value = name,
            placeholder = stringResource(R.string.nome_do_usuario),
            validate = { validateEmail(name) }, /* TODO: ajuda para a validação do nome e não do tipo Email*/
            isUserInteracted = false
        )
        Spacer(modifier = modifier.height(17.dp))
        PasswordTextField(
            onValueChange = { newPassword ->
                viewModel.onPasswordChange(newPassword)
            },
            value = password,
            placeholder = stringResource(id = R.string.digite_sua_senha),
            validate = { password ->
                validatePassword(password)
            },
            isUserInteracted = isUserInteracted
        )
        Spacer(modifier = modifier.height(17.dp))
        PasswordTextField(
            onValueChange = { newConfirmPassword ->
                viewModel.onConfirmPassword(newConfirmPassword)
            },
            value = confirmPassword,
            placeholder = stringResource(id = R.string.confirme_sua_senha),
            validate = { confirmedPassword ->
                validatePassword(confirmedPassword)
            },
            isUserInteracted = isUserInteracted
        )
        Spacer(modifier = modifier.height(35.dp))
        CustomButton(
            onClick = {
                navController.navigateToVerificationLink()

            }, text = stringResource(R.string.registrar),
            backgroundColor = primary100,
            fontSize = 18.sp,
            fontFamily = dmSansFamily
        )
    }
}

fun validatedName(name: String): NameErrorType {
    return when {
        name.isEmpty() -> NameErrorType.Empty
        else -> NameErrorType.None
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(
        navController = rememberNavController()
    )
}
