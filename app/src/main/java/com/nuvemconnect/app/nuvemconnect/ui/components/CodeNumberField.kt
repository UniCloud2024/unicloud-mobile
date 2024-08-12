package com.nuvemconnect.app.nuvemconnect.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nuvemconnect.app.nuvemconnect.ui.theme.button_color
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily

@Composable
fun CodeNumberField(
    modifier: Modifier = Modifier,
    value: Int = 0
) {
    var number by remember {
        mutableIntStateOf(value)
    }


    OutlinedTextField(
        value = number.toString(),
        onValueChange = { newNumber ->
            number = newNumber.toInt()
        },
        textStyle = LocalTextStyle.current.copy(
            fontSize = 14.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,

        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        shape = RoundedCornerShape(8),

        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = button_color

        ),
        modifier = modifier
            .width(41.dp)
            .height(46.dp),
        singleLine = true,
    )
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun CodeNumberFieldPreview() {
    CodeNumberField()
}