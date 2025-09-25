package com.example.presentation.chat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChatTextField(): Unit {
    var textFieldMessageValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .padding(horizontal = 5.dp)
            .background(color = Color.White)
    ) {
        HorizontalDivider(color = Color.LightGray, modifier =  Modifier.padding(bottom = 10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = textFieldMessageValue,
                onValueChange = {textFieldMessageValue = it},
                shape = RoundedCornerShape(24.dp),
                placeholder = { Text("Type something here...") },
                modifier = Modifier
                    .padding(WindowInsets.navigationBars.asPaddingValues())
                    .padding(horizontal = 5.dp)
                    .weight(1f),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xfff0f0f0),
                    focusedContainerColor = Color.Transparent,
                    unfocusedTextColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedIndicatorColor = Color.Transparent)
            )

            Icon(
                imageVector = Icons.Filled.ArrowCircleRight,
                contentDescription = "",
                modifier = Modifier.size(55.dp),
                tint = Color(0xff279fdc)
            )
        }
    }
}