package com.nuvemconnect.app.nuvemconnect.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nuvemconnect.app.nuvemconnect.ui.theme.NuvemConnectTheme

@Composable
fun CodeInputField(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .width(41.dp)
            .height(46.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CodeInputFieldPreview() {
    NuvemConnectTheme {
        CodeInputField()
    }
}