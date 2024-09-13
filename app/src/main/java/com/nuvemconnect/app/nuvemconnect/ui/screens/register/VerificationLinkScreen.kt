package com.nuvemconnect.app.nuvemconnect.ui.screens.register

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.nuvemconnect.app.nuvemconnect.ui.components.TopBar
import com.nuvemconnect.app.nuvemconnect.ui.theme.NuvemConnectTheme
import com.nuvemconnect.app.nuvemconnect.ui.theme.dmSansFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.neutral100
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary100

@Composable
fun VerificationLinkScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val gifEnabledLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }.build()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(top = 36.dp, start = 16.dp, end = 16.dp)
    ) {
        TopBar(navController = navController, headingTitle = "", subtitleText = "",
            onBackClick = { navController.navigateUp() })
        Spacer(modifier = modifier.height(50.dp))
        Text(
            text = "Verifique sua conta",
            fontSize = 28.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = modifier.height(36.dp))
        Text(
            text = "o link de ativação da conta foi enviado para o endereço de e-mail que você forneceu",
            fontSize = 14.sp,
            fontFamily = dmSansFamily,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            color = neutral100
        )
        Spacer(modifier = modifier.height(30.dp))
        AsyncImage(
            imageLoader = gifEnabledLoader,
            modifier = modifier
                .size(157.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://s3-alpha-sig.figma.com/img/959b/c919/d314f6f1ae97cc84bedbd0aa56423ec1?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Yz4ju4rsT45C6wH0Y8qEO6O01SJXV1e522gJjsgpOwFWMzoZBnR75bYIL4gM5ywl4xOQi4iEy3SK~qCMx03uM9EHSuXQJzoO2iVAro6YOomK9avirkrDNS5I~iS8syb7vNglUJKdufUOl1KU11w0NMxr5BrEu6h~OpW2iG4qUQRt6yUImLZoSPT6t~HbZaGNREfyrJE7RIJhRm3rkUhdnhLSGV8vojpgUZr-SxVuH0N07Gva7RtELMTfr2g4SRhKoQyRAbcrgDb0DZP26FzPN-ey2lBhVJkOqqASUsWtGqb~2B5AMeTuIlgdNS6URtmChjOFSu0VLTYPgA8QWqiVZQ__")
                .size(Size.ORIGINAL)
                .build(),
            contentDescription = "Gif do link para o email",
        )
        Spacer(modifier = modifier.height(30.dp))
        Row {
            Text(
                text = "Não recebeu o email? ",
                fontFamily = dmSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = neutral100
            )
            Text(
                text = "enviar novamente",
                fontFamily = dmSansFamily,
                fontWeight = FontWeight.Normal,
                color = primary100,
                fontSize = 16.sp
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun VerificationLinkScreenPreview() {
    NuvemConnectTheme {
        VerificationLinkScreen(navController = rememberNavController())
    }
}