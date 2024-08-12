package com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.navigation.Screens
import com.nuvemconnect.app.nuvemconnect.ui.components.CustomButton
import com.nuvemconnect.app.nuvemconnect.ui.theme.mediumGray
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary

@Composable
fun PasswordCode(modifier: Modifier = Modifier,navController: NavController) {
    Column {
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
                    contentDescription = stringResource(R.string.voltar),
                    modifier = modifier
                        .width(18.dp)
                        .height(18.dp)
                        .fillMaxSize()

                )
            }
            Spacer(modifier = modifier.height(30.dp))
            Text(
                text = stringResource(R.string.title_forgot_password_2),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                modifier = modifier
            )
            Spacer(modifier = modifier.height(26.dp))
            Text(
                text = stringResource(R.string.subtitle_forgot_password_2),
                fontSize = 16.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                fontFamily = poppinsFontFamily,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = modifier.height(45.dp))
          Row {

          }
            Spacer(modifier = modifier.height(26.dp))
            CustomButton(
                onClick = { 
                    navController.navigate(Screens.ResetPassword.route)
                },
                text = stringResource(R.string.verificar),
                backgroundColor = primary,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(21.dp))

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PasswordCodePreview() {
    PasswordCode(navController = rememberNavController())
}