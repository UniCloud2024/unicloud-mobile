package com.nuvemconnect.app.nuvemconnect.ui.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomTextField
import com.nuvemconnect.app.nuvemconnect.ui.components.PasswordTextField
import com.nuvemconnect.app.nuvemconnect.ui.theme.mediumBlue
import com.nuvemconnect.app.nuvemconnect.ui.theme.mediumGray

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(top = 36.dp, start = 16.dp, end = 16.dp)
    ) {
        Button(
            onClick = { }, shape = RoundedCornerShape(10.dp),
            modifier = modifier.width(72.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = mediumGray,
                contentColor = Color.Black
            )
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                contentDescription = "Voltar",
                modifier = modifier
                    .width(18.dp)
                    .height(18.dp)
                    .fillMaxSize()

            )
        }
        Spacer(modifier = modifier.height(30.dp))
        Text(
            text = "Registre-se",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Spacer(modifier = modifier.height(26.dp))
        Text(
            text = "Insira suas informações pessoais",
            fontSize = 16.sp,
            color = Color.Gray,
            fontWeight = FontWeight.W300
        )
        Spacer(modifier = modifier.height(29.dp))
        CustomTextField(
            onValueChange = {},
            value = "",
            titleContainer = "Nome do Usuario",
            placeholder = "Digite seu nome"
        )
        Spacer(modifier = modifier.height(17.dp))
        CustomTextField(
            onValueChange = {},
            value = "",
            titleContainer = "Email",
            placeholder = "Digite seu email"
        )
        Spacer(modifier = modifier.height(17.dp))
        PasswordTextField(
            onValueChange = {},
            value = "",
            titleContainer = "Senha",
            placeholder = "Digite sua senha"
        )
        Spacer(modifier = modifier.height(17.dp))
        PasswordTextField(
            onValueChange = {},
            value = "",
            titleContainer = "Confirme sua senha",
            placeholder = "Confirme sua senha"
        )
        Spacer(modifier = modifier.height(35.dp))
        CustomButton(
            onClick = { /*TODO*/ }, text = "Registrar",
            backgroundColor = mediumBlue,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen()
}
