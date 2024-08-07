package com.nuvemconnect.app.nuvemconnect.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nuvemconnect.app.nuvemconnect.R

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
    fontSize: TextUnit = 16.sp,
    border: BorderStroke? = null,
    fontWeight: FontWeight = FontWeight.W400
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
        shape = RoundedCornerShape(20.dp),
        contentPadding = contentPadding,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.google_icon),
            contentDescription = "icone_google",
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(
            text = text,
            fontSize = fontSize,
            style = textStyle,
            color = textColor,
            fontWeight = fontWeight,
            modifier = Modifier.padding(vertical = 9.dp)
        )
    }
}

@Preview
@Composable
private fun CustomButtonPreview() {
    GoogleButton(onClick = { /*TODO*/ }, text = "Registre-se")
}