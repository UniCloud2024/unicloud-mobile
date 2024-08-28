package com.nuvemconnect.app.nuvemconnect.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary300
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary600
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary950

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.logo_name),
            fontWeight = FontWeight.Bold,
            color = primary950,
            fontSize = 40.sp,
            modifier = modifier.padding(top = 100.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.nuvem_connect_logo),
            contentDescription = stringResource(
                id = R.string.logo
            ),
            modifier = modifier.padding(top = 85.9.dp)
        )
        CustomButton(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 120.1.dp),
            onClick = {
                navController.navigate(Screens.Register.route)
            },
            text = "Registre-se",
            backgroundColor = primary600,
            textColor = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        CustomButton(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            onClick = {
                navController.navigate(Screens.Login.route)
            },
            text = "Entrar",
            backgroundColor = primary300,
            textColor = primary950,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = modifier.height(56.dp))
        Text(text = helpText(), textAlign = TextAlign.Center)


    }
}

@Composable
fun helpText(): AnnotatedString {
    val help = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 14.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
            )
        ) {
            append(stringResource(R.string.precisa_de_ajuda))
        }

        withStyle(
            style = SpanStyle(
                fontSize = 14.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,

                textDecoration = TextDecoration.Underline
            )
        ) {
            append(stringResource(R.string.entre_em_contato))
            pushStringAnnotation(tag = "URL", annotation = " futuro link aqui")
        }

        withStyle(
            style = SpanStyle(
                fontSize = 14.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(stringResource(R.string.conosco))
            pushStringAnnotation(tag = "URL", annotation = " futuro link aqui")
        }
    }
    return help
}


@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    val navController = rememberNavController()
    WelcomeScreen(navController = navController)
}