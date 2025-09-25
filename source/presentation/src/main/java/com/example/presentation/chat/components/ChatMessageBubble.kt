package com.example.presentation.chat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChatMessageBubble(content: String, isOwnMessage: Boolean, timeStamp: String): Unit {
    Column(
        modifier = Modifier.padding(bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if (isOwnMessage) Arrangement.End else Arrangement.Start
        ) {
            Box(
                Modifier
//                .fillMaxWidth()
                    .padding(end = if(!isOwnMessage) 60.dp else 0.dp)
                    .padding(start = if(isOwnMessage) 60.dp else 0.dp)
                    .heightIn(min = 35.dp)
                    .widthIn(min = 35.dp)
                    .background(
                        color = if(isOwnMessage) Color(0xff279fdc) else Color(0xfff0f0f0),
                        RoundedCornerShape(8.dp)
                    )
            ){
                Text(
                    text = content,
                    color = if(isOwnMessage) Color.White else Color.Black,
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if (isOwnMessage) Arrangement.End else Arrangement.Start
        ) {
            Text(text = timeStamp, color = Color.LightGray)
        }
    }
}