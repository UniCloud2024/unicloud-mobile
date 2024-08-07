package com.nuvemconnect.app.nuvemconnect.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nuvemconnect.app.nuvemconnect.ui.theme.PurpleGrey40
import com.nuvemconnect.app.nuvemconnect.ui.theme.mediumGray
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    titleContainer: String,
    placeholder: String,
    ) {
    Column(
        modifier = Modifier.fillMaxWidth()

    ) {
        Text(text = titleContainer, fontSize = 16.sp, fontWeight = FontWeight.W500)
        Spacer(modifier = modifier.height(5.dp))
        OutlinedTextField(
            value = value,
            onValueChange = { newValue ->
                if (newValue.length <= 40) onValueChange(newValue)
            },
            singleLine = true,
            placeholder = { Text(text = placeholder) },
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            shape = RoundedCornerShape(8),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = mediumGray,
                focusedBorderColor = primary,
                focusedTextColor = Color.Black,
                unfocusedContainerColor = mediumGray,


                ),

            )
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun CustomTextFieldPreview() {
    val value by rememberSaveable {
        mutableStateOf("")
    }
    CustomTextField(
        onValueChange = {},
        value = value,
        titleContainer = "Titulo do container",
        placeholder = "Descrição do texto"
    )

}