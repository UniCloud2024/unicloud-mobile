package com.nuvemconnect.app.nuvemconnect.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
    contentPadding: PaddingValues = PaddingValues(16.dp),
    textColor: Color = MaterialTheme.colorScheme.surface,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.W400
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.run {
            buttonColors(
                containerColor = backgroundColor,
                contentColor = contentColor
            )
        },
        shape = RoundedCornerShape(20.dp),
        contentPadding = contentPadding,
        ) {
        Text(
            text = text,
            fontSize = fontSize,
            style = textStyle,
            color = textColor,
            fontWeight = fontWeight,
            modifier = Modifier.padding(vertical = 7.dp)
        )
    }
}

@Preview
@Composable
private fun CustomButtonPreview() {
    CustomButton(onClick = { /*TODO*/ }, text = "Registre-se")
}