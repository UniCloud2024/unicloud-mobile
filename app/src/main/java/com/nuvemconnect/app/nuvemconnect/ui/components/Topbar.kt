package com.nuvemconnect.app.nuvemconnect.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.secondary100

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    headingSize: TextUnit = 28.sp,
    navController: NavController,
    headingTitle: String = "Insira seu texto",
    subtitleText: String = "Insira um subtitulo",
    subtitleSize: TextUnit = 16.sp,
    onBackClick: (() -> Unit)? = null
) {

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_chevron_left_24),
            contentDescription = stringResource(id = R.string.voltar),
            modifier = modifier
                .clip(RoundedCornerShape(6.dp))
                .width(46.dp)
                .height(46.dp)
                .background(secondary100)
                .clickable {
                    onBackClick?.invoke() ?: navController.navigateUp()
                },
            contentScale = ContentScale.Crop,
        )

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
        headingSize = 32.sp,
        navController = NavController(LocalContext.current)
    )
}