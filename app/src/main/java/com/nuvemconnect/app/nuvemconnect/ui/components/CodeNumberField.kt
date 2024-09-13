package com.nuvemconnect.app.nuvemconnect.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nuvemconnect.app.nuvemconnect.ui.theme.dmSansFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.primary100
import com.nuvemconnect.app.nuvemconnect.ui.theme.white_two

@Composable
fun CodeNumberField(
    modifier: Modifier = Modifier,
) {
    var otpText by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = otpText,
        onValueChange = {
            if (it.length <= 6) {
                otpText = it
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                repeat(6) { index ->
                    val char = when {
                        index >= otpText.length -> ""
                        else -> otpText[index].toString()
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .width(41.dp)
                            .height(46.dp)
                            .background(
                                color = white_two,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = if (index == otpText.length) primary100 else Color.Transparent,
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        Text(
                            text = char,
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            lineHeight = 45.sp,
                            fontFamily = dmSansFamily,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Spacer(modifier = modifier.width(6.dp))
                }
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun CodeNumberFieldPreview() {
    CodeNumberField()
}