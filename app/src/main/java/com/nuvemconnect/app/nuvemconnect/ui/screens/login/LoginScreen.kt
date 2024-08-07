package com.nuvemconnect.app.nuvemconnect.ui.screens.login

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.GoogleButton
import com.nuvemconnect.app.nuvemconnect.ui.components.PasswordTextField
import com.nuvemconnect.app.nuvemconnect.ui.theme.mediumBlue
import com.nuvemconnect.app.nuvemconnect.ui.theme.mediumGray

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Spacer(modifier = modifier.height(70.dp))
        Text(text = "Bem vindo de volta!", fontSize = 32.sp, fontWeight = FontWeight.W900)
        Spacer(modifier = modifier.height(15.dp))
        Text(
            text = "Para começar, faça login em sua conta",
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
            color = Color.Gray
        )
        Spacer(modifier = modifier.height(41.dp))
        CustomTextField(
            onValueChange = { newEmail ->
                email = newEmail
            },
            value = email,
            titleContainer = "Email",
            placeholder = "Digite seu e-mail"
        )
        Spacer(modifier = modifier.height(17.dp))
        PasswordTextField(
            onValueChange = { newPassword ->
                password = newPassword
            },
            value = password,
            titleContainer = "Password",
            placeholder = "Senha"
        )

        Text(
            text = "Esqueceu sua senha?",
            modifier = modifier
                .align(Alignment.End)
                .padding(top = 10.dp),
            fontSize = 16.sp,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = modifier.height(35.dp))
        CustomButton(
            onClick = { /*TODO*/ },
            text = "Entrar",
            modifier = modifier.fillMaxWidth(),
            backgroundColor = mediumBlue
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
                text = " Ou faça seu login ",
                fontSize = 14.sp,
                color = Color.Gray
            )
            HorizontalDivider(
                thickness = 1.dp,
                modifier = modifier.weight(1f)
            )
        }
        Spacer(modifier = modifier.height(22.dp))
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
                text = "Não tem uma conta?",
                fontWeight = FontWeight.W300,
                fontSize = 14.sp,
                color = Color.Gray,
            )
            Text(text = " Inscreva-se", color = mediumBlue, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}
