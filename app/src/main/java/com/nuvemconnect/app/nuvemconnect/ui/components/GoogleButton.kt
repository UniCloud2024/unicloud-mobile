package com.nuvemconnect.app.nuvemconnect.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily

@Composable
fun GoogleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
    contentPadding: PaddingValues = PaddingValues(16.dp),
    textColor: Color = MaterialTheme.colorScheme.surface,
    fontSize: TextUnit = 18.sp,
    border: BorderStroke? = null,
    fontWeight: FontWeight = FontWeight.SemiBold
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        border = border,
        colors = ButtonDefaults.run {
            buttonColors(
                containerColor = backgroundColor,
                contentColor = contentColor,
            )

        },
        shape = RoundedCornerShape(100.dp),
        contentPadding = contentPadding,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.google_icon),
            contentDescription = "icone_google",
            tint = Color.Unspecified
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(
            text = text,
            fontSize = fontSize,
            style = textStyle,
            color = textColor,
            fontFamily = poppinsFontFamily,
            fontWeight = fontWeight,
        )
    }
}

@Preview
@Composable
private fun CustomButtonPreview() {
    GoogleButton(onClick = { /*TODO*/ }, text = "Registre-se")
}