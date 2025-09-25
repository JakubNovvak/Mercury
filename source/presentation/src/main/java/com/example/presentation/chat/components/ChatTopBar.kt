package com.example.presentation.chat.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatTopBar(onCancel: ()-> Unit, chatName: String) {
    Column {

        Row(
            modifier = Modifier
                .height(110.dp)
                .fillMaxWidth()
                .padding(top = 35.dp, start = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                Image(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Account icon",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(60.dp)
                )

                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = chatName,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W600,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                    }

                    Text(
                        text = " Offline",
                        color = Color.Gray
                    )
                }
            }
            Button(
                onClick = onCancel,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = "Cancel Icon",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .size(40.dp)
                )
            }
        }
        HorizontalDivider(color = Color.LightGray)
    }
}