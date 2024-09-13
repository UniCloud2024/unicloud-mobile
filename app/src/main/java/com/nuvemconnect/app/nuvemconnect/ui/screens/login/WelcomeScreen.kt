package com.nuvemconnect.app.nuvemconnect.ui.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.nuvemconnect.app.nuvemconnect.ui.theme.base_white
import com.nuvemconnect.app.nuvemconnect.ui.theme.dmSansFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary100

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = modifier
            .paint(
                painter = painterResource(id = R.drawable.background_screen_welcome),
                sizeToIntrinsics = true,
                contentScale = ContentScale.Crop
            )


    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painter = painterResource(id = R.drawable.nuvem_connect_logo),
                contentDescription = stringResource(
                    id = R.string.logo
                ),
                tint = Color.White,
                modifier = modifier.padding(top = 170.dp)
            )
            Text(
                text = stringResource(id = R.string.logo_name),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 40.sp,
                modifier = modifier.padding(25.dp)
            )
            Spacer(modifier = modifier.padding(top = 139.dp))
            CustomButton(
                modifier = modifier
                    .fillMaxWidth(),
                onClick = {
                    navController.navigate(Screens.Login.route)
                },
                text = "Login",
                fontFamily = dmSansFamily,
                backgroundColor = primary100,
                textColor = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            CustomButton(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                onClick = {
                    navController.navigate(Screens.Register.route)
                },
                text = "Registre-se",
                backgroundColor = Color.Transparent,
                textColor = Color.White,
                fontFamily = dmSansFamily,
                fontSize = 18.sp,
                border = BorderStroke(1.dp, Color.White),
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = modifier.height(56.dp))
            Text(text = helpText(), textAlign = TextAlign.Center)


        }
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
                color = base_white
            )
        ) {
            append(stringResource(R.string.precisa_de_ajuda))
        }

        withStyle(
            style = SpanStyle(
                fontSize = 14.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = base_white,
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
                textDecoration = TextDecoration.Underline,
                color = base_white
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