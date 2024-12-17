package com.example.jobposting.ui.component.textfield

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobposting.R
import com.example.jobposting.ui.component.text.JobText
import com.example.jobposting.ui.theme.DarkGrey
import com.example.jobposting.ui.theme.Error
import com.example.jobposting.ui.theme.customTypography

@Composable
fun JobTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue = TextFieldValue(),
    onChanceValue: (TextFieldValue) -> Unit = {},
    label: String,
    isPasswordField: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
    validator: (String) -> String? = { _ -> null },
    isError: Boolean = false,
    errorMessage: String? = null,
    maxLine: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    readOnly: Boolean = false
) {
    var passwordVisible by rememberSaveable { mutableStateOf(isPasswordField) }
    var error by remember { mutableStateOf(errorMessage) }

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
        TextField(
            value = value,
            onValueChange = {
                onChanceValue(it)
                error = validator(it.text)
            },
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(BorderStroke(width = 1.dp, color = DarkGrey), shape = RoundedCornerShape(12.dp)),
            colors = TextFieldDefaults.colors().copy(
                disabledPlaceholderColor = DarkGrey,
                focusedPlaceholderColor = DarkGrey,
                unfocusedPlaceholderColor = DarkGrey,
                cursorColor = Color.Black,
                disabledLabelColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                errorContainerColor = Color.White,
                disabledContainerColor = Color.White,
                errorIndicatorColor = Color.Transparent,
                errorTextColor = Error
            ),
            shape = RoundedCornerShape(12.dp),
            placeholder = { JobText(text = label, color = DarkGrey, style = customTypography.headlineSmall) },
            trailingIcon = {
                if (isPasswordField) {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(if (passwordVisible) R.drawable.password_icons else R.drawable.password_icons_visible),
                            contentDescription = null,
                            modifier = modifier
                                .height(24.dp)
                                .width(24.dp)
                        )
                    }
                } else {
                    trailingIcon?.invoke()
                }
            },
            isError = isError,
            visualTransformation = if (passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            maxLines = maxLine,
            keyboardOptions = keyboardOptions,
            readOnly = readOnly
        )
        error?.let {
            JobText(text = "Error Message", color = Error)
        }
    }

}

@Preview
@Composable
private fun JobTextFieldPreview() {
    JobTextField(label = "Label", isPasswordField = true)
}