package com.nuvemconnect.app.nuvemconnect.ui.screens.register

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.model.error.EmailErrorType
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.PasswordTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.TopBar
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginViewModel
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {

    val name by viewModel.name.collectAsStateWithLifecycle()
    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val confirmPassword by viewModel.confirmPassword.collectAsStateWithLifecycle()


    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(top = 36.dp, start = 16.dp, end = 16.dp)
    ) {
        TopBar(
            headingTitle = stringResource(R.string.registre_se),
            subtitleText = stringResource(R.string.insira_suas_informacoes_pessoais),
            navController = navController,
            onBackClick = { navController.navigateUp() }
        )
        Spacer(modifier = modifier.height(29.dp))
        CustomTextField(
            onValueChange = { newEmail ->
                viewModel.onEmailChange(newEmail)
            },
            value = email,
            titleContainer = stringResource(id = R.string.email),
            placeholder = stringResource(id = R.string.digite_seu_email),
            validate = { EmailErrorType.Empty },
            isUserInteracted = false
        )
        Spacer(modifier = modifier.height(17.dp))
        CustomTextField(
            onValueChange = { newName ->
                viewModel.onName(newName)
            },
            value = name,
            titleContainer = stringResource(R.string.nome_do_usuario),
            placeholder = stringResource(R.string.digite_seu_nome),
            validate = { EmailErrorType.Empty },
            isUserInteracted = false
        )
        Spacer(modifier = modifier.height(17.dp))
        PasswordTextField(
            onValueChange = { newPassword ->
                viewModel.onPasswordChange(newPassword)
            },
            value = password,
            titleContainer = stringResource(id = R.string.senha),
            placeholder = stringResource(id = R.string.digite_sua_senha)
        )
        Spacer(modifier = modifier.height(17.dp))
        PasswordTextField(
            onValueChange = { newConfirmPassword ->
                viewModel.onConfirmPassword(newConfirmPassword)
            },
            value = confirmPassword,
            titleContainer = stringResource(id = R.string.confirme_sua_senha),
            placeholder = stringResource(id = R.string.digite_sua_senha)
        )
        Spacer(modifier = modifier.height(35.dp))
        CustomButton(
            onClick = {
                navController.navigate(Screens.VerificationLink.route)

            }, text = stringResource(R.string.registrar),
            backgroundColor = primary,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(
        navController = rememberNavController()
    )
}
