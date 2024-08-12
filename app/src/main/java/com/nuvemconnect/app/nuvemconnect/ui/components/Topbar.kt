package com.nuvemconnect.app.nuvemconnect.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nuvemconnect.app.nuvemconnect.ui.theme.mediumGray
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    headingSize: TextUnit = 28.sp,
    headingTitle: String = "Insira seu texto",
    subtitleText: String = "Insira um subtitulo",
    subtitleSize: TextUnit = 16.sp
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier

            .fillMaxWidth()
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
            text = headingTitle,
            fontSize = headingSize,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(26.dp))
        Text(
            text = subtitleText,
            fontSize = subtitleSize,
            color = Color.Gray,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify,
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun TopBarPreview() {
    TopBar(
       modifier = Modifier,
        headingSize = 32.sp
    )
}