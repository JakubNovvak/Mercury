package com.example.presentation.login.components

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    isPasswordField: Boolean = false
): Unit {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {Text(label)},
        singleLine = true,
        visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            unfocusedTextColor = Color.Black,
            focusedTextColor = Color.Black
        )
    )
}