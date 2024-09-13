package com.nuvemconnect.app.nuvemconnect.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nuvemconnect.app.nuvemconnect.R
import com.nuvemconnect.app.nuvemconnect.model.error.EmailErrorType
import com.nuvemconnect.app.nuvemconnect.ui.theme.dmSansFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.error100
import com.nuvemconnect.app.nuvemconnect.ui.theme.neutral20
import com.nuvemconnect.app.nuvemconnect.ui.theme.poppinsFontFamily
import com.nuvemconnect.app.nuvemconnect.ui.theme.white_two

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    leadingIcon: Painter = painterResource(id = R.drawable.ic_launcher_foreground),
    value: String,
    placeholder: String,
    validate: (String) -> EmailErrorType,
    isUserInteracted: Boolean
) {
    val error = if (isUserInteracted) validate(value) else EmailErrorType.None

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = modifier.height(5.dp))
        OutlinedTextField(
            value = value,
            onValueChange = { newValue ->
                if (newValue.length <= 40)
                    onValueChange(newValue)
            },
            leadingIcon = {
                Icon(
                    painter = leadingIcon,
                    modifier = modifier.size(24.dp),
                    contentDescription = "Leading Icon"
                )
            },
            singleLine = true,
            placeholder = {
                Text(
                    text = placeholder,
                    fontFamily = dmSansFamily,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    modifier = modifier.fillMaxWidth()
                )
            },
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            shape = RoundedCornerShape(8),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = white_two,
                focusedBorderColor = white_two,
                focusedTextColor = Color.Black,
                unfocusedContainerColor = white_two,
            ),
            textStyle = TextStyle(
                fontFamily = poppinsFontFamily,

                ),
            isError = error != EmailErrorType.None,
        )
        if (error != EmailErrorType.None) {
            Text(
                text = error.message,
                color = error100,
                fontSize = 12.sp,
                fontFamily = poppinsFontFamily
            )
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CustomTextFieldPreview() {
    val value by rememberSaveable {
        mutableStateOf("")
    }
    CustomTextField(
        onValueChange = {},
        value = value,
        placeholder = "Descrição do texto",
        validate = { EmailErrorType.None },
        isUserInteracted = false,
    )

}